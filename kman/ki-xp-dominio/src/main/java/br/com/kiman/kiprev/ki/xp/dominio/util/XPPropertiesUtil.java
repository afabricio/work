package br.com.kiman.kiprev.ki.xp.dominio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public class XPPropertiesUtil {

	private static final Logger logger = Logger
			.getLogger(XPPropertiesUtil.class);

	private static final String ERRO_AO_CARREGAR_O_ARQUIVO = "Erro ao carregar o arquivo de propriedades.";
	private static final String ERRO_AO_ATUALIZAR_O_ARQUIVO = "Erro ao atualizar o arquivo: ";

	private static final String APPLICATION_PROPERTIES = System
			.getProperty("appconfig.root") + "/ki-xp-application.properties";
	private static Properties applicationProperties;
	private static long lastTimeConfigLoaded = 0;
	private static final String ARQUIVO_PROPERTIES_NAO_EXISTE = "Arquivo "
			+ APPLICATION_PROPERTIES + " não encontrado.";

	private static File getApplicationFile() {
		File file = new File(APPLICATION_PROPERTIES);
		if (!file.exists()) {
			logger.error(ARQUIVO_PROPERTIES_NAO_EXISTE);
			throw new NegocioException(ERRO_AO_CARREGAR_O_ARQUIVO);
		}
		return file;
	}

	public static String getCaminhoArquivo() {
		return APPLICATION_PROPERTIES;
	}

	private static void loadApplicationProperties() {
		try {
			applicationProperties = new Properties();
			File properties = getApplicationFile();
			InputStream inStream = new FileInputStream(properties);
			applicationProperties.load(inStream);
			lastTimeConfigLoaded = properties.lastModified();
		} catch (Exception e) {
			logger.error(ARQUIVO_PROPERTIES_NAO_EXISTE, e);
			throw new NegocioException(ERRO_AO_CARREGAR_O_ARQUIVO
					+ getApplicationFile().getName(), e);
		}
	}

	public static String getProperty(String property) {
		if (applicationProperties == null
				|| getApplicationFile().lastModified() > lastTimeConfigLoaded) {
			loadApplicationProperties();
		}
		return applicationProperties.getProperty(property);
	}

	public static void setProperty(String key, String value) {
		applicationProperties.setProperty(key, value);
	}

	public static void atualizaArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream(getApplicationFile());
			applicationProperties.store(fos, "");
			fos.flush();
			fos.close();
		} catch (Exception e) {
			throw new NegocioException(ERRO_AO_ATUALIZAR_O_ARQUIVO
					+ getApplicationFile().getName(), e);
		}
	}
}
