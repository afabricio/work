package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.io.IOException;
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
import br.com.kiman.kiprev.ki.xp.integration.ted.ArrecadacaoTedDTO;

@Stateless
@Batch(name = ArrecadacaoTedBatch.NOME_BATCH)
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class ArrecadacaoTedBatch implements BatchInterface {

	public static final String NOME_BATCH = "ARREC-RET-DEP-BANC-ITAU-XP";

	private static final Logger logger = Logger.getLogger(ArrecadacaoTedBatch.class);
	private static final String SIM = "S", NAO = "N";

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

			OutMap oInicia = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int037.p_inicia",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
							.out("pnSessao", Integer.class).out("pcInterfAtiva", String.class));

			sessao = oInicia.getOut("pnSessao");
			String interfAtiva = oInicia.getOut("pcInterfAtiva");

			if (SIM.equals(interfAtiva)) {
				
				List<ArrecadacaoTedDTO> listaTed = buscaTed();
				
				OutMap oInsereEnca = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int037.p_insere_enca",
						with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
								.out("pnIdEnca", Number.class));
				
				Number idEnca = oInsereEnca.getOut("pnIdEnca");
				
				 StoredProcedureQuery storedProc = dao.registerProcedure(
				 "kpvcust11.pck_db_ki_xp_int037.p_insere_deta",
						 with("pnIdEnca", Long.class)
						 .and("pcIdExterno", String.class)
						 .and("pcBanco", String.class)
						 .and("pcAgencia", String.class)
						 .and("pcDgAgencia", String.class)
						 .and("pcConta", String.class)
						 .and("pcDgConta", String.class)
						 .and("pcCnpjSeguradora", String.class)
						 .and("pdDataDeposito", Date.class)
						 .and("pdDataContabil", Date.class)
						 .and("pcNumLancamento", String.class)
						 .and("pnValor", Double.class)
						 .and("pcBancoOrigem", String.class)
						 .and("pcAgenciaOrigem", String.class)
						 .and("pcDgAgenciaOrigem", String.class)
						 .and("pcContaOrigem", String.class)
						 .and("pcDgContaOrigem", String.class)	 
						 .and("pcCpfCnpjRemetente", String.class)
						 .and("pnStatus", Integer.class)
						 .and("pcNumCobranca", String.class)
						 .and("pcCodCuenta", String.class));

				for (ArrecadacaoTedDTO ted : listaTed) {
					try {


						OutMap existeRegistroOUT = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int037.p_ignora_registro",
								with("pcIdExterno", ted.getTransactionKey(), String.class)
								.and("pnStatus",ted.getStatus(),Integer.class)
								.out("pcIgnora",String.class));

						String existeRegistro = existeRegistroOUT.getOut("pcIgnora");

						if (NAO.equals(existeRegistro)) {

							 dao.executeStoredProcedure(storedProc,
								 with("pnIdEnca", idEnca.longValue())
								 .and("pcIdExterno", ted.getTransactionKey())
								 .and("pcBanco", ted.getInsurerBankNumber())
								 .and("pcAgencia",  ted.getInsurerAgency())
								 .and("pcDgAgencia",  ted.getInsurerAgencyDigit())
								 .and("pcConta",  ted.getInsurerAccount())							         
								 .and("pcDgConta",  ted.getInsurerAccountDigit())
								 .and("pcCnpjSeguradora",  ted.getInsurerDocument())
								 .and("pdDataDeposito",  ted.getDepositDateAsDate())
								 .and("pdDataContabil", ted.getTransferDateAsDate())
								 .and("pcNumLancamento", ted.getTransferId())
								 .and("pnValor", ted.getValue())								
								 .and("pcBancoOrigem", ted.getCustomerBankNumber())
								 .and("pcAgenciaOrigem", ted.getCustomerAgency())
								 .and("pcDgAgenciaOrigem", ted.getCustomerAgencyDigit())
								 .and("pcContaOrigem", ted.getCustomerAccount())
								 .and("pcDgContaOrigem", ted.getCustomerAccountDigit())
								 .and("pcCpfCnpjRemetente", ted.getCustomerDocument())
								 .and("pnStatus", ted.getStatus())
								 .and("pcNumCobranca", ted.getInvoiceCode())
								 .and("pcCodCuenta", ted.getCertificateCode()));

						}

					} catch (Exception e) {
						logger.error(NOME_BATCH + " - pnSessao: " + sessao);
						logger.error(e.getMessage(), e);
						logMonitor(sessao, e.getMessage(), "A");
					}

				}
				
				
				 dao.executeProcedure("kpvcust11.pck_db_ki_xp_int037.p_insere_deposito",
						with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
						.and("pnSessao",sessao,Integer.class));
				

			}

		} catch (Exception e) {
			if (sessao != null) {
				logMonitor(sessao, e.getMessage(), "A");
			}
			throw new BatchException("Erro ao executar o batch: " + NOME_BATCH, e);
		} finally {
			if (sessao != null) {
				dao.executeProcedure("kpvcust11.pck_db_ki_xp_int037.p_finaliza",
						with("pnSessao", sessao, Integer.class));
			}
		}
		
		Monitor monitor = dao.findSingleByNamedQuery(Monitor.BUSCA_STATUS_MONITOR,
				with("session", sessao.toString())
				.and("codProcesso", "11371"), Monitor.class);
		
		return BatchResult.fromValue(monitor.getStatus());
	}

	private List<ArrecadacaoTedDTO> buscaTed() throws IOException {
		String url = parametroService.buscaParametro(Interface.RETORNO_DEPOSITO_BANCARIO, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_ARRECADACAO_TED);

		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.FUNDOS, null));

		Map<String, Object> headers = Maps.newHashMap();
		headers.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		Response response = restService.get(url, headers, filtros);
		StatusType statusInfo = response.getStatusInfo();
		if (!statusInfo.getFamily().equals(Family.SUCCESSFUL)) {
			throw new BatchException(String.format("Erro ao executar o serviço: %s - Erro: %s - %s", url,
					statusInfo.getStatusCode(), statusInfo.getReasonPhrase()));
		}

		return response.readEntity(new GenericType<List<ArrecadacaoTedDTO>>() {
		});

	}

	private void logMonitor(Integer sessao, String msg, String criticidade) {
		try {
			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int037.p_log_erro",
					with("pnSessao", sessao)
					.and("pcTipCriticidade", criticidade)//'A' ou 'P' (A Aborta registro e conta erro e P Mensagem informativa não conta erro)
					.and("pnIdMensagem", 4)//4 -Erro no processamento.
					.and("pcMsgErro", msg));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
