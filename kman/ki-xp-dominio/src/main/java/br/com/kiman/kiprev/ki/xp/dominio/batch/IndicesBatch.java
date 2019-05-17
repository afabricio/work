package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;
import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestLogger;
import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestService;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dao.OutMap;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Monitor;
import br.com.kiman.kiprev.ki.xp.dominio.exception.BatchException;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;
import br.com.kiman.kiprev.ki.xp.dominio.util.XPUtil;
import br.com.kiman.kiprev.ki.xp.integration.indices.IndiceFinanceiro;
import br.com.kiman.kiprev.ki.xp.integration.indices.ValorIndice;

@Stateless
@Batch(name = IndicesBatch.NOME_BATCH)
public class IndicesBatch implements BatchInterface {

	public static final String NOME_BATCH = "INFOP-PRO-VALORES-INDICES-XP";

	private static final Logger logger = Logger.getLogger(IndicesBatch.class);
	private static final String SIM = "S";

	@Inject
	private GenericDAO dao;

	@Inject
	private ParametroBean parametroService;

	@Inject
	private ClienteRestService restService;

	@Override
	public BatchResult execute() {
		Integer sessao = null;

		try {

			OutMap oInicia = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int004.p_inicia",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
							.out("pnSessao", Integer.class).out("pcInterfAtiva", String.class));

			sessao = oInicia.getOut("pnSessao");
			String interfAtiva = oInicia.getOut("pcInterfAtiva");

			if (SIM.equals(interfAtiva)) {

				List<IndiceFinanceiro> listaIndices = buscaIndices();

				StoredProcedureQuery storedProc = dao.registerProcedure(
						"kpvcust11.pck_db_ki_xp_int004.p_cadastra_valor_indice",
						with("PCCODEMPRESA", String.class).and("PNSESSAO", Integer.class).and("PCINDICE", String.class)
								.and("PNVALOR", BigDecimal.class).and("PNRENTABILIDADE", Double.class)
								.and("PDDATA", Date.class));

				for (IndiceFinanceiro indice : listaIndices) {

					try {

						OutMap oIndiceCadastrado = dao.executeProcedure(
								"kpvcust11.pck_db_ki_xp_int004.p_indice_cadastrado",
								with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
										.and("pnSessao", sessao, Integer.class)
										.and("pcIndice", indice.getName(), String.class)
										.out("pnExisteIndice", String.class).out("pdDataUltimoIndice", Date.class)
										.out("pcTipPeriodicidade", String.class));

						String tipPeriodicidade = oIndiceCadastrado.getOut("pcTipPeriodicidade");
						String existeIndice = oIndiceCadastrado.getOut("pnExisteIndice");
						Date dataUltimoIndice = oIndiceCadastrado.getOut("pdDataUltimoIndice");

						if (SIM.equals(existeIndice)) {

							List<ValorIndice> listaValores = buscaValorPorIndice(indice);

							for (ValorIndice valorIndice : listaValores) {

								Date dataIndice = XPUtil.parseFormatDate(valorIndice.getDate());

								if (dataIndice.after(dataUltimoIndice) && (tipPeriodicidade.equals("DI")
										|| (tipPeriodicidade.equals("ME") && valorIndice.getProfitability() != 0))) {

									dao.executeStoredProcedure(storedProc,
											with("PCCODEMPRESA", SystemConfEnum.DEFAULT_COMPANY.getValue())
													.and("PNSESSAO", sessao).and("PCINDICE", indice.getName())
													.and("PNVALOR", valorIndice.getValue())
													.and("PNRENTABILIDADE", valorIndice.getProfitability())
													.and("PDDATA", dataIndice));
								}

							}

						}
					} catch (Exception e) {
						logger.error(NOME_BATCH + " - pnSessao: " + sessao);
						logger.error(e.getMessage(), e);
						logMonitor(sessao, e.getMessage());
					}

				}
			}
			

		} catch (Exception e) {

			if (sessao != null) {
				logMonitor(sessao, e.getMessage());
			}
			throw new BatchException("Erro ao executar o batch: " + NOME_BATCH, e);
		} finally {
			if (sessao != null) {
				dao.executeProcedure("kpvcust11.pck_db_ki_xp_int004.p_finaliza",
						with("pnSessao", sessao, Integer.class));
			}
		}
		
		Monitor monitor = dao.findSingleByNamedQuery(Monitor.BUSCA_STATUS_MONITOR,
				with("session", sessao.toString())
				.and("codProcesso", "11041"), Monitor.class);
		
		return BatchResult.fromValue(monitor.getStatus());
	}

	private List<IndiceFinanceiro> buscaIndices() {
		String url = parametroService.buscaParametro(Interface.INDICES, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_INDICES);

		Response response = executaRest(url, null);
		return response.readEntity(new GenericType<List<IndiceFinanceiro>>() {
		});
	}

	private List<ValorIndice> buscaValorPorIndice(IndiceFinanceiro indice) {
		String url = parametroService.buscaParametro(Interface.INDICES, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_VALOR_INDICE);

		Response response = executaRest(String.format(url, indice.getId()), indice.getId());
		return response.readEntity(new GenericType<List<ValorIndice>>() {
		});

	}

	private static final String ERRO_EXECUTAR_SERVICE_REST = "Erro ao executar o serviço: %s - Erro: %s - %s";

	private Response executaRest(String url, Object numDocumento) {
		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.INDICES, numDocumento));

		Map<String, Object> headers = Maps.newHashMap();
		headers.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		Response response = restService.get(url, headers, filtros);
		StatusType statusInfo = response.getStatusInfo();
		if (!statusInfo.getFamily().equals(Family.SUCCESSFUL)) {
			throw new BatchException(String.format(ERRO_EXECUTAR_SERVICE_REST, url, statusInfo.getStatusCode(),
					statusInfo.getReasonPhrase()));
		}
		return response;
	}

	private void logMonitor(Integer sessao, String msg) {
		try {
			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int004.p_log_erro",
					with("pnSessao", sessao).and("pcMsgErro", msg));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
