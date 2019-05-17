package br.com.kiman.kiprev.ki.xp.dominio.service;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters;
import br.com.kiman.kiprev.ki.xp.dominio.entity.ParametroInterface;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ParametroBean {

	@Inject
	private GenericDAO genericDAO;

	public String buscaParametro(Interface interf, Grupo grupo,
			ParametroEnum param) {

		List<ParametroInterface> parametro = genericDAO.findByNamedQuery(
				"findParametroById",
				with("pNumeroInterface", interf.getNumero()).and("pGrupo",
						grupo.getNome()).and("pCodParametro", param.name()));

		if (parametro.size() == 0) {
			throw new NegocioException("Parâmetro não encontrado (" + grupo
					+ ":" + param + ":" + interf + ")");
		}

		return parametro.get(0).getValor();
	}

	public List<ParametroInterface> buscaParametros(Interface interf) {
		return genericDAO.findByNamedQuery(
				ParametroInterface.BUSCA_POR_NUM_INTERFACE,
				QueryParameters.with("pNumeroInterface", interf.getNumero()));
	}

}
