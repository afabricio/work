package br.com.kiman.kiprev.ki.xp.dominio.facade;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.SecurityService;

@Stateless(name = "SecurityFacade", mappedName = "ejb/SecurityFacade")
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class SecurityFacade {

	@Inject
	private SecurityService service;

	private static final Logger logger = Logger.getLogger(SecurityFacade.class);

	public String getEncryptedPassword(String password) {

		try {

			return service.getEncryptedPassword(password);

		} catch (Exception e) {
			logger.error("Erro ao buscar a senha criptografada. ", e);
			throw new NegocioException(e);
		}

	}

}
