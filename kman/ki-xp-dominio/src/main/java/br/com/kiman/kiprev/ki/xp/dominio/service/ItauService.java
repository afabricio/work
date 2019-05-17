package br.com.kiman.kiprev.ki.xp.dominio.service;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;
import static br.com.kiman.kiprev.ki.xp.dominio.util.XPPropertiesUtil.atualizaArquivo;
import static br.com.kiman.kiprev.ki.xp.dominio.util.XPPropertiesUtil.getProperty;
import static br.com.kiman.kiprev.ki.xp.dominio.util.XPPropertiesUtil.setProperty;

import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import com.sun.jersey.api.representation.Form;

import br.com.kiman.kiprev.ki.xp.dominio.autenticacao.DecoderAES;
import br.com.kiman.kiprev.ki.xp.dominio.autenticacao.EncoderAES;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.integration.itau.Token;

public abstract class ItauService {

	private static final String INI_VECTOR_ITAU_AUTENTICADOR = "itau.autorizador.vector";
	private static final String CRIPTOGRAFA_SENHA_ITAU_AUTORIZADOR = "itau.autorizador.criptografa";
	private static final String SENHA_ITAU_AUTORIZADOR = "itau.autorizador.senha";
	private static final String CHAVE_ITAU_AUTORIZADOR = "itau.autorizador.chave";

	private static final String S = "S";

	@Inject
	private EncoderAES encoder;
	@Inject
	private DecoderAES decoder;

	@Inject
	protected GenericDAO dao;

	@Inject
	protected ParametroBean parametroService;

	protected Token buscaTokenAutenticacao() {
		String urlAutorizador = parametroService.buscaParametro(Interface.ENVIO_BOLETO_ONLINE, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_AUTORIZADOR_ITAU);

		String itauChave = getProperty(CHAVE_ITAU_AUTORIZADOR);

		WebTarget webTargetAutorizador = ClientBuilder.newClient().target(urlAutorizador);

		Builder builder = webTargetAutorizador.request(MediaType.APPLICATION_JSON)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Authorization:", "Basic headerValue");

		Form form = new Form();
		form.add("scope", "readonly");
		form.add("grant_type", "client_credentials");
		form.add("client_id", itauChave);
		form.add("client_secret", getSenha());

		Response autorizadorResponse = builder.post(Entity.form(form));

		Token token = autorizadorResponse.readEntity(Token.class);

		token.setClientID(itauChave);

		return token;
	}

	private String getSenha() {
		String senha = null;
		boolean criptografaSenha = S.equals(getProperty(CRIPTOGRAFA_SENHA_ITAU_AUTORIZADOR));
		if (criptografaSenha) {
			senha = getProperty(SENHA_ITAU_AUTORIZADOR);
			String senhaCriptografada = encoder.encryt(senha);
			setProperty(SENHA_ITAU_AUTORIZADOR, senhaCriptografada);
			setProperty(INI_VECTOR_ITAU_AUTENTICADOR, encoder.getIVector());
			setProperty(CRIPTOGRAFA_SENHA_ITAU_AUTORIZADOR, "N");
			atualizaArquivo();
		} else {
			String senhaCriptografada = getProperty(SENHA_ITAU_AUTORIZADOR);
			String initializationVector = getProperty(INI_VECTOR_ITAU_AUTENTICADOR);
			senha = decoder.decrypt(initializationVector, senhaCriptografada);
		}
		return senha;
	}

	protected String buscaCNPJSeguradora() {

		String cnpj = dao.findByNativeQuery(
				" select num_id from "
						+ " KIPREV.PERSONAS PJ INNER JOIN KIPREV.EMPRESA E on E.COD_PER_JURIDICA = PJ.COD_PER_JURIDICA "
						+ "             INNER JOIN KIPREV.id_personas ID on ID.cod_persona = PJ.cod_persona "
						+ " where E.COD_EMPRESA = ? " + "  AND ID.cod_tipo_id = ? ",
				with(SystemConfEnum.DEFAULT_COMPANY.getValue()).and("5"), String.class);

		return StringUtils.leftPad(cnpj, 14, "0");

	}
}
