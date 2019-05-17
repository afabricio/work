package br.com.kiman.kiprev.ki.xp.jaxws.security;

import javax.ejb.EJB;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import br.com.kiman.kiprev.ki.xp.dominio.facade.SecurityFacade;

public class KiprevAuthenticationPasswordEncoder implements PasswordEncoder {

	@EJB(mappedName = "ejb/SecurityFacade")
	SecurityFacade service;

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws DataAccessException {

		String encodePassword = service.getEncryptedPassword(rawPass);

		return encodePassword.equals(encPass);
	}

	@Override
	public String encodePassword(String encPass, Object rawPass) throws DataAccessException {
		return null;
	}

}
