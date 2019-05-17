package br.com.kiman.kiprev.ki.xp.dominio.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public class PropertiesUtil {

	private static final String APPLICATION_PROPERTIES = System
			.getProperty("appconfig.root") + "/application.properties";
	private static Properties applicationProperties;
	private static long lastTimeConfigLoaded = 0;

	static {
		loadApplicationProperties();
	}

	private static File getApplicationFile() {
		return new File(APPLICATION_PROPERTIES);
	}

	private static void loadApplicationProperties() {
		try {
			applicationProperties = new Properties();
			File properties = getApplicationFile();
			InputStream inStream = new FileInputStream(properties);
			applicationProperties.load(inStream);
			lastTimeConfigLoaded = properties.lastModified();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao carregar o arquivo: "
					+ getApplicationFile().getName(), e);
		}
	}

	public static String getProperty(String property) {
		if (getApplicationFile().lastModified() > lastTimeConfigLoaded) {
			loadApplicationProperties();
		}
		return applicationProperties.getProperty(property);
	}

}
