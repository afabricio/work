package br.com.kiman.kiprev.ki.xp.dominio.util;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

public class BeanUtil {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        BeanManager beanManager2 = CDI.current().getBeanManager();
        Bean<T> bean = (Bean<T>) beanManager2.getBeans(clazz).iterator().next();
        CreationalContext<T> ctx = beanManager2.createCreationalContext(bean);
        return (T) beanManager2.getReference(bean, clazz, ctx);
    }
}
