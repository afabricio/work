package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
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
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;
import br.com.kiman.kiprev.ki.xp.integration.cotas.Cota;
import br.com.kiman.kiprev.ki.xp.integration.fundos.FundoInvestimentoDTO;
import br.com.kiman.kiprev.ki.xp.integration.fundos.ListaFundosDTO;

@Stateless
@Batch(name = CotasBatch.NOME_BATCH)
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class CotasBatch implements BatchInterface {

	public static final String NOME_BATCH = "INFOP-PRO-COTAS-FUNDOS-XP";

	private static final Logger logger = Logger.getLogger(CotasBatch.class);
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

			OutMap oInicia = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int002.p_inicia",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
							.out("pnSessao", Integer.class).out("pcInterfAtiva", String.class));

			sessao = oInicia.getOut("pnSessao");
			String interfAtiva = oInicia.getOut("pcInterfAtiva");

			if (SIM.equals(interfAtiva)) {

				List<FundoInvestimentoDTO> listaFundos = buscaFundoInvestimento();

				StoredProcedureQuery storedProc = dao.registerProcedure(
						"kpvcust11.pck_db_ki_xp_int002.p_cadastra_cota_fundo",
								with("PCCODEMPRESA	", String.class)
								.and("PCCNPJFUNDO", String.class)
								.and("PNVALORCOTA", BigDecimal.class)
								.and("PDDATACOTA", Date.class)
								.and("PNPATRIMONIOLIQUIDO", BigDecimal.class)
								.and("PNSESSAO", Integer.class));

				for (FundoInvestimentoDTO fundo : listaFundos) {
					try {

						OutMap oExisteFundo = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int002.p_existe_fundo",
								with("PCCODEMPRESA", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
										.and("PNSESSAO", sessao, Integer.class)
										.and("PCCNPJFUNDO",fundo.getCnpj())
										.out("PCFUNDOCADASTRADO", String.class)
										.out("PDDATAULTIMACOTA", Date.class));

						String existeFundo = oExisteFundo.getOut("PCFUNDOCADASTRADO");
						Date dataUltimaCota = oExisteFundo.getOut("PDDATAULTIMACOTA");

						if (SIM.equals(existeFundo)) {
							List<Cota> listaCotas = buscaCotasPorFundo(fundo);

							for (Cota cota : listaCotas) {


								if (dataUltimaCota == null || cota.getDate().after(dataUltimaCota)) {

									dao.executeStoredProcedure(storedProc,
											with("PCCODEMPRESA	", SystemConfEnum.DEFAULT_COMPANY.getValue())
													.and("PCCNPJFUNDO", fundo.getCnpj())
													.and("PNVALORCOTA", cota.getValue())
													.and("PDDATACOTA", cota.getDate())
													.and("PNPATRIMONIOLIQUIDO", cota.getNetEquity())
													.and("PNSESSAO", sessao));
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
				dao.executeProcedure("kpvcust11.pck_db_ki_xp_int002.p_finaliza",
						with("pnSessao", sessao, Integer.class));
			}
		}
		
		Monitor monitor = dao.findSingleByNamedQuery(Monitor.BUSCA_STATUS_MONITOR,
				with("session", sessao.toString())
				.and("codProcesso", "11021"), Monitor.class);
		
		return BatchResult.fromValue(monitor.getStatus());
	}


	private List<Cota> buscaCotasPorFundo(FundoInvestimentoDTO fundo) {
		String urlCotas = parametroService.buscaParametro(Interface.COTAS, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_COTAS);

		Response response = executaRest(String.format(urlCotas, fundo.getId()), fundo.getId());
		
		List<Cota> cotas =  response.readEntity(new GenericType<List<Cota>>(){});
		Collections.sort(cotas);
		
		return cotas;
	}

	private List<FundoInvestimentoDTO> buscaFundoInvestimento() {
		String urlFundos = parametroService.buscaParametro(Interface.FUNDOS, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_FUNDOS);

		Response response = executaRest(urlFundos, null);

		return response.readEntity(ListaFundosDTO.class).getInvestmentFunds();

	}

	private static final String ERRO_EXECUTAR_SERVICE_REST = "Erro ao executar o serviço: %s - Erro: %s - %s";

	private Response executaRest(String url, Object numDocumento) {
		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.COTAS, numDocumento));

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
			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int002.p_log_erro",
					with("pnSessao", sessao).and("pcMsgErro", msg));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
