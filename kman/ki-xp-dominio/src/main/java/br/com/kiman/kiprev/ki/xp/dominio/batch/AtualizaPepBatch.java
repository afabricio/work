package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.exception.BatchException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;

@Stateless
@Batch(name = "atualizapep")
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class AtualizaPepBatch implements BatchInterface {

	@Inject
	private GenericDAO dao;

	@Override
	public BatchResult execute() {
		try {

			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int005.p_atualiza_pep",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class));
			
			return BatchResult.SUCESSO;

		} catch (Exception e) {
			throw new BatchException("Erro ao executar o batch de de atualização de cotas", e);
		}

		
	}



}
