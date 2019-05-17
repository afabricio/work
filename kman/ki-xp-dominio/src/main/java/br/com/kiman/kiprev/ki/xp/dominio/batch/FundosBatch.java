package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.StoredProcedureQuery;
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
import br.com.kiman.kiprev.ki.xp.dominio.util.XPUtil;
import br.com.kiman.kiprev.ki.xp.integration.fundos.FundoAdministrator;
import br.com.kiman.kiprev.ki.xp.integration.fundos.FundoInvestimentoDTO;
import br.com.kiman.kiprev.ki.xp.integration.fundos.FundoManager;
import br.com.kiman.kiprev.ki.xp.integration.fundos.FundoProperties;
import br.com.kiman.kiprev.ki.xp.integration.fundos.ListaFundosDTO;

@Stateless
@Batch(name = FundosBatch.NOME_BATCH)
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class FundosBatch implements BatchInterface {

	public static final String NOME_BATCH = "INFOP-PRO-FUNDOS-XP";

	private static final Logger logger = Logger.getLogger(FundosBatch.class);
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

			OutMap oInicia = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int001.p_inicia",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
							.out("pnSessao", Integer.class).out("pcInterfAtiva", String.class)
							.out("pcCodMoeda", String.class));

			sessao = oInicia.getOut("pnSessao");
			String interfAtiva = oInicia.getOut("pcInterfAtiva");
			String codMoeda = oInicia.getOut("pcCodMoeda");

			if (SIM.equals(interfAtiva) && (codMoeda != null && !codMoeda.isEmpty())) {

				StoredProcedureQuery storedProc = dao.registerProcedure(
						"kpvcust11.pck_db_ki_xp_int001.p_cadastra_fundo",
						with("PCCODEMPRESA", String.class).and("PCDESCRIPCION", String.class)
								.and("PCCODINVEXT", String.class).and("PNDIASAPLICACAO", Integer.class)
								.and("PNDIASRESGATE", Integer.class).and("PCCNPJ", String.class)
								.and("PCSTATUSATIVO", String.class).and("PNQTDDIASFLOATADMIN", Integer.class)
								.and("PDDATAINIVIGENCIA", Date.class).and("PCTIPOCONVERSAO", Integer.class)
								.and("PCNOMEADMINISTRADOR", String.class).and("PCCNPJADMINISTRADOR", String.class)
								.and("PCNOMEGESTOR", String.class).and("PCCNPJGESTOR", String.class)
								.and("PDDATAULTIMAALTERACAO", Date.class).and("PCCODMOEDA", String.class)
								.and("PNSESSAO", Integer.class));

				List<FundoInvestimentoDTO> listaFundos = buscaFundos();

				for (FundoInvestimentoDTO fundo : listaFundos) {
					try {

						Optional<FundoProperties> properties = Optional.ofNullable(fundo.getProperties());
						Optional<FundoAdministrator> administrator = Optional.ofNullable(fundo.getAdministrator());
						Optional<FundoManager> manager = Optional.ofNullable(fundo.getManager());
						
						dao.executeStoredProcedure(storedProc,
								with("PCCODEMPRESA", SystemConfEnum.DEFAULT_COMPANY.getValue())
										.and("PCDESCRIPCION", fundo.getName()).and("PCCODINVEXT", fundo.getCode())
										.and("PNDIASAPLICACAO", fundo.getInvestmentQuotationDays())
										.and("PNDIASRESGATE", fundo.getRedemptionQuotationDays())
										.and("PCCNPJ", fundo.getCnpj())
										.and("PCSTATUSATIVO", properties.map(p -> p.getActiveAsString()).orElse(""))
										.and("PNQTDDIASFLOATADMIN", fundo.getRedemptionSettlementDays())
										.and("PDDATAINIVIGENCIA", XPUtil.parseFormatDate(fundo.getStartDate()))
										.and("PCTIPOCONVERSAO", fundo.getQuotaType())
										.and("PCNOMEADMINISTRADOR", administrator.map(a -> a.getName()).orElse(""))
										.and("PCCNPJADMINISTRADOR", administrator.map(a -> a.getCnpj()).orElse(""))
										.and("PCNOMEGESTOR", manager.map(m -> m.getName()).orElse(""))
										.and("PCCNPJGESTOR", manager.map(m -> m.getCnpj()).orElse(""))
										.and("PDDATAULTIMAALTERACAO", XPUtil.parseFormatDate(fundo.getUpdatedOn()))
										.and("PCCODMOEDA", codMoeda).and("PNSESSAO", sessao));

					} catch (Exception e) {
						logger.error(NOME_BATCH + " - pnSessao: " + sessao);
						logger.error(e.getMessage(), e);
						//temErro = true;
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
				dao.executeProcedure("kpvcust11.pck_db_ki_xp_int001.p_finaliza",
						with("pnSessao", sessao, Integer.class));
			}
		}
		
		
		Monitor monitor = dao.findSingleByNamedQuery(Monitor.BUSCA_STATUS_MONITOR,
				with("session", sessao.toString())
				.and("codProcesso", "11011"), Monitor.class);
		
		return BatchResult.fromValue(monitor.getStatus());
	}

	private List<FundoInvestimentoDTO> buscaFundos() throws IOException {
		String url = parametroService.buscaParametro(Interface.FUNDOS, Grupo.PARAMETRO_FIXO, ParametroEnum.URL_FUNDOS);

		Response response = executaRest(url, null);
		return response.readEntity(ListaFundosDTO.class).getInvestmentFunds();
	}

	private static final String ERRO_EXECUTAR_SERVICE_REST = "Erro ao executar o serviço: %s - Erro: %s - %s";

	private Response executaRest(String url, Object numDocumento) {
		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.FUNDOS, numDocumento));

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
			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int001.p_log_erro",
					with("pnSessao", sessao).and("pcMsgErro", msg));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
