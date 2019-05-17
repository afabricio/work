package br.com.kiman.kiprev.ki.xp.autenticacao;

import static br.com.kiman.kiprev.ki.xp.dominio.util.XPPropertiesUtil.atualizaArquivo;
import static br.com.kiman.kiprev.ki.xp.dominio.util.XPPropertiesUtil.getProperty;
import static br.com.kiman.kiprev.ki.xp.dominio.util.XPPropertiesUtil.setProperty;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.autenticacao.DecoderAES;
import br.com.kiman.kiprev.ki.xp.dominio.autenticacao.EncoderAES;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.ParametroInterface;
import br.com.kiman.kiprev.ki.xp.dominio.entity.UsuarioKiprev;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.facade.ParametroFacade;

public class KiprevConnector {

	private static final Logger logger = Logger
			.getLogger(KiprevConnector.class);
	private static final String ERRO_AO_TENTAR_CONECTAR_NO_KIPREV = "Erro ao tentar conectar no kiprev.";
	private static final String INITIALIZATION_VECTOR = "initialization.vector";
	private static final String CRIPTOGRAFA_SENHA_KIPREV = "criptografa.senha.kiprev";
	private static final String SENHA_KIPREV = "senha.kiprev";
	private static final String PARAMS = "userid=%s/%s@%s&otherparams=cod_usuario=%s";
	private static final String POST = "POST";
	private static final String S = "S";

	@EJB
	private ParametroFacade parametroFacade;
	@Inject
	private EncoderAES encoder;
	@Inject
	private DecoderAES decoder;

	public String conectaNoKiprev(UsuarioKiprev usuario)
			throws MalformedURLException, IOException {
		List<ParametroInterface> parametrosInterfaces = parametroFacade
				.buscaParametros(Interface.LOGIN_AD);
		String sid = ParametroEnum.BASE_DADOS_KIPREV
				.extraiValorParametro(parametrosInterfaces);
		String urlForms = ParametroEnum.URL_KIPREV_FORMS
				.extraiValorParametro(parametrosInterfaces);

		HttpURLConnection connection = null;
		connection = (HttpURLConnection) new URL(urlForms).openConnection();
		connection.setRequestMethod(POST);
		connection.setDoOutput(true);
		connection.setConnectTimeout(20000);
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.writeBytes(String.format(PARAMS, getProperty("usuario.kiprev"),
				getSenha(), sid, usuario.getCodUsuario()));
		wr.flush();
		wr.close();

		String resultado = extraiResponse(connection);
		if (HttpServletResponse.SC_OK != connection.getResponseCode()) {
			logger.error(ERRO_AO_TENTAR_CONECTAR_NO_KIPREV + "\n" + resultado);
			throw new NegocioException(ERRO_AO_TENTAR_CONECTAR_NO_KIPREV);
		}
		connection.disconnect();
		return resultado;
	}

	private String getSenha() {
		String senha = null;
		boolean criptografaSenha = S
				.equals(getProperty(CRIPTOGRAFA_SENHA_KIPREV));
		if (criptografaSenha) {
			senha = getProperty(SENHA_KIPREV);
			String senhaCriptografada = encoder.encryt(senha);
			setProperty(SENHA_KIPREV, senhaCriptografada);
			setProperty(INITIALIZATION_VECTOR, encoder.getIVector());
			setProperty(CRIPTOGRAFA_SENHA_KIPREV, "N");
			atualizaArquivo();
		} else {
			String senhaCriptografada = getProperty(SENHA_KIPREV);
			String initializationVector = getProperty(INITIALIZATION_VECTOR);
			senha = decoder.decrypt(initializationVector, senhaCriptografada);
		}
		return senha;
	}

	private String extraiResponse(HttpURLConnection connection)
			throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		String inputLine;
		StringBuffer buffer = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			buffer.append(inputLine);
		}
		in.close();
		return buffer.toString();
	}

}
