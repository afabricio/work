package br.com.kiman.kiprev.ki.xp.dominio.batch;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Ged;
import br.com.kiman.kiprev.ki.xp.dominio.entity.ParametroInterface;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;
import br.com.kiman.kiprev.ki.xp.integration.ged.GEDService;

@Batch(name = GedBatch.NOME_BATCH)
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class GedBatch implements BatchInterface {

	public static final String NOME_BATCH = "INTEGRA-GED-XP";
	private Logger logger = Logger.getLogger(GedBatch.class);

	@Inject
	private GEDService gedService;

	@Inject
	private ParametroBean parametroBean;

	@Override
	public BatchResult execute() {

		List<ParametroInterface> parametros = parametroBean.buscaParametros(Interface.GED);

		boolean temErro = false;
		for (Ged ged : gedService.buscaPendentes()) {
			try {
				temErro = !gedService.processaGed(ged, parametros) || temErro;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				temErro = true;
			}
		}
		return temErro ? BatchResult.FINALIZADO_COM_ERRO : BatchResult.SUCESSO;
	}

}
