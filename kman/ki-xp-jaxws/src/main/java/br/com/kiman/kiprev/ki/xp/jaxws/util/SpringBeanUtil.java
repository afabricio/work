package br.com.kiman.kiprev.ki.xp.jaxws.util;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringBeanUtil {
	private static Logger logger = Logger.getLogger(SpringBeanUtil.class);

	private SpringBeanUtil() {
	}

	public static Object getBean(String beanID) {
		Object springBean = null;
		try {
			WebApplicationContext context = ContextLoader
					.getCurrentWebApplicationContext();
			if (context == null)
				return null;
			springBean = context.getBean(beanID);
		} catch (Exception ex) {
			logger.error("Erro", ex);
		}
		return springBean;
	}

	@SuppressWarnings("unchecked")
	public static <C> C getBean(Class<C> classType) {
		String className = classType.getSimpleName();
		String beanName = className.substring(0, 1).toLowerCase()
				+ className.substring(1, className.length());

		return (C) getBean(beanName);
	}

	@SuppressWarnings("unchecked")
	public static <C> C getBeanByType(Class<C> clazz) {
		Object springBean = null;
		try {
			WebApplicationContext context = ContextLoader
					.getCurrentWebApplicationContext();
			if (context == null)
				return null;
			springBean = context.getBean(clazz);
		} catch (Exception ex) {
			logger.error("Erro", ex);
		}
		return (C) springBean;
	}
}
