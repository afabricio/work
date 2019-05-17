package br.com.kiman.kiprev.ki.xp.dominio.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.ParametroInterface;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;

@Stateless
public class ParametroFacade {

	@Inject
	private ParametroBean parametroBean;

	public List<ParametroInterface> buscaParametros(Interface interf) {
		return parametroBean.buscaParametros(interf);
	}

	public String buscaParametro(Interface interf, Grupo grupo, ParametroEnum parametro) {
		return parametroBean.buscaParametro(interf, grupo, parametro);
	}

}
