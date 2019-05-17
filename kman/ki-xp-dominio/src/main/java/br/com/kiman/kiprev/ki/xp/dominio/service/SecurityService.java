package br.com.kiman.kiprev.ki.xp.dominio.service;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dao.OutMap;

@Stateless(name = SecurityService.NAME_EJB,  mappedName=SecurityService.NAME_EJB)
public class SecurityService {

	public static final String NAME_EJB = "SecurityService";
	
	
	@Inject
	GenericDAO dao;
	
	public String getEncryptedPassword(String password) {

		OutMap oInicia = dao.executeProcedure("pck_db_ncl_usuarios.p_EncriptaSenha",
				with("PCSENHA", password, String.class)
				.out("PRSENHAENCRIPTADA", String.class));

		String encripted = oInicia.getOut("PRSENHAENCRIPTADA");
		return encripted;
		
	}
	
}
