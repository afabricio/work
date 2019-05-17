package br.com.kiman.kiprev.ki.xp.dominio.autenticacao;

import static br.com.kiman.kiprev.ki.xp.dominio.util.PropertiesUtil.getProperty;
import static java.lang.String.format;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.util.PropertiesUtil;

public class AutenticadorAD {

	private Logger logger = Logger.getLogger(AutenticadorAD.class);
	private static final String ERRO_NA_CONFIGURACAO = "Erro ao tentar conectar no LDAP. Verifique as configurações. ";
	private static final String LOGIN_INVALIDO = "Usuário ou senha inválidos.";
	private static final String USUARIO_SENHA_OBRIGATORIO = "Necessário informar usuário e senha.";
	private static final String EMPTY = "";
	private static final String SIMPLE = "simple";

	private static final String ARROBA = "@";
	private static final String PONTO = ".";
	private static final String VIRGULA = ",";
	private static final String DC = "DC";
	private static final String FOLLOW = "follow";

	private static final String LDAP_IP = "ldap.ip";
	private static final String LDAP_PORT = "ldap.port";
	private static final String LDAP_BASE_DN = "ldap.baseDn";
	private static final String LDAP_KEY_SEARCH = "ldap.keySearch";

	private static final String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	private static final String KEY_SEARCH_PATTERN = "%s=%s";

	private static final String URL_AD = "ldap://%s:%s/%s";

	public void autentica(String usuario, String senha) {
		valida(usuario, senha);

		Hashtable<String, String> env = getParams(usuario, senha);
		NamingEnumeration<SearchResult> namingEnumeration = null;
		try {
			namingEnumeration = new InitialDirContext(env).search(
					EMPTY,
					format(KEY_SEARCH_PATTERN, getProperty(LDAP_KEY_SEARCH),
							usuario), getSearchControl());
			SearchResult next = namingEnumeration.next();
			next.getAttributes();
		} catch (Exception e) {
			trataErro(e, env);
		} finally {
			try {
				if (namingEnumeration != null) {
					namingEnumeration.close();
				}
			} catch (NamingException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private void valida(String usuario, String senha) {
		if (usuario == null || usuario.isEmpty()) {
			throw new NegocioException(USUARIO_SENHA_OBRIGATORIO);
		}
		if (senha == null || senha.isEmpty()) {
			throw new NegocioException(USUARIO_SENHA_OBRIGATORIO);
		}
	}

	private void trataErro(Exception e, Hashtable<String, String> env) {
		env.remove(Context.SECURITY_CREDENTIALS);

		if (e instanceof AuthenticationException
				|| e.getCause() instanceof AuthenticationException) {
			throw new NegocioException(LOGIN_INVALIDO, e);
		}
		String message = ERRO_NA_CONFIGURACAO + env;
		logger.error(message, e);
		throw new NegocioException(ERRO_NA_CONFIGURACAO, e);
	}

	private SearchControls getSearchControl() {
		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		return searchControls;
	}

	private Hashtable<String, String> getParams(String username, String password) {
		String baseDn = PropertiesUtil.getProperty(LDAP_BASE_DN);
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, getURL(baseDn));
		env.put(Context.SECURITY_AUTHENTICATION, SIMPLE);
		env.put(Context.SECURITY_PRINCIPAL, domainConverter(username, baseDn));
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.REFERRAL, FOLLOW);
		return env;
	}

	private String getURL(String baseDn) {
		return String.format(URL_AD, getProperty(LDAP_IP),
				getProperty(LDAP_PORT), baseDn);
	}

	private String domainConverter(String userAd, String baseDn) {
		String newStr = userAd + ARROBA;
		int first, last;
		baseDn = baseDn + VIRGULA;
		while (baseDn.contains(DC)) {
			first = baseDn.indexOf(DC);
			last = baseDn.indexOf(VIRGULA, first);
			newStr = newStr + baseDn.substring(first + 3, last);
			baseDn = baseDn.substring(last);
			newStr = newStr + PONTO;
		}
		return newStr.substring(0, newStr.length() - 1);
	}
}
