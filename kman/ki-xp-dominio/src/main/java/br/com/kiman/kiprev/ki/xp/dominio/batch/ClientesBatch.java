package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

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
import br.com.kiman.kiprev.ki.xp.dominio.dao.JPQLs;
import br.com.kiman.kiprev.ki.xp.dominio.dao.OutMap;
import br.com.kiman.kiprev.ki.xp.dominio.dao.StoredQueryPaginator;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Monitor;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Pessoa;
import br.com.kiman.kiprev.ki.xp.dominio.exception.BatchException;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;
import br.com.kiman.kiprev.ki.xp.integration.clientes.Customer;

@Stateless
@Batch(name = "INFOP-PRO-CLIENTES-XP")
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class ClientesBatch implements BatchInterface {

	@Inject
	private GenericDAO dao;

	@Inject
	private ParametroBean parametroService;

	private static final Logger logger = Logger.getLogger(ClientesBatch.class);

	@Inject
	StoredQueryPaginator paginator;

	@Inject
	private ClienteRestService clienteRestService;

	@Override
	public BatchResult execute() {
		Integer sessao = null;
		
		try {

			OutMap oInicia = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int029.p_inicia",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
							.out("pnSessao", Integer.class).out("pcInterfAtiva", String.class));

			sessao = oInicia.getOut("pnSessao");
			String interfAtiva = oInicia.getOut("pcInterfAtiva");

			if (interfAtiva.equals("S")) {

				String urlAtualizaClienteXP = parametroService.buscaParametro(Interface.ATUALIZA_CLIENTES,
						Grupo.PARAMETRO_FIXO, ParametroEnum.URL_UPD_CLIENTES);

				Integer registrosPorPagina = dao.executeFunction("kpvcust11.pck_db_ki_param.F_Obtem_Param_Interf",
						with("G_PRM_FIXO").and("QTDE_LISTA_CPF").and("29"), Integer.class);

				paginator.setNamedQuery(JPQLs.N_PESSOA_FISICA);
				paginator.setPageSize(registrosPorPagina);

				StoredProcedureQuery storedProc = registraProcedure();

				List<Pessoa> listaPessoasKiprev = paginator.next();
				while (paginator.hasNext()) {

					List<Customer> listaPessoasXP = buscaAtualizacaoPessoasXP(urlAtualizaClienteXP, listaPessoasKiprev);

					for (Pessoa pessoa : listaPessoasKiprev) {
						try {
							Long numDocumento = Long.valueOf(pessoa.getDocumentoPrincipal().getNumero());
							Customer customerXP = listaPessoasXP.stream()
									.filter(c -> c.getPersonDocument().equals(numDocumento)).findFirst().orElse(null);
							
							if (customerXP == null) {
								String messagem = "O serviço não retornou a pessoa com o cpf " + numDocumento;
								logMonitor(sessao, messagem );
								logger.error(messagem);
							} else {
								executaProcedure(sessao, storedProc, customerXP, pessoa);
							}

						} catch (Exception e) {
							// loga o erro, mas continua a atualização
							if (sessao != null)
								logMonitor(sessao, e.getMessage());
							logger.error("Erro ao tentar atualizar o cliente: DOC "
									+ pessoa.getDocumentoPrincipal().getNumero(), e);
						}
					}
					listaPessoasKiprev = paginator.next();
				}
			}
			
		} catch (Exception e) {

			if (sessao != null)
				logMonitor(sessao, e.getMessage());

			String emsg = "Erro ao executar o batch de atualização de clientes";

			logger.error(emsg, e);

			throw new BatchException(emsg, e);
		} finally {
			if (sessao != null) {
				dao.executeProcedure("kpvcust11.pck_db_ki_xp_int029.p_finaliza", with("pnSessao", sessao, Integer.class));
			}
		}
		
		Monitor monitor = dao.findSingleByNamedQuery(Monitor.BUSCA_STATUS_MONITOR,
				with("session", sessao.toString())
				.and("codProcesso", "11291"), Monitor.class);
		
		return BatchResult.fromValue(monitor.getStatus());
	}

	private void executaProcedure(Integer sessao, StoredProcedureQuery storedProc, Customer customerXP, Pessoa pessoa) {
		dao.executeStoredProcedure(storedProc, with("PCCODEMPRESA", SystemConfEnum.DEFAULT_COMPANY.getValue())
				.and("PNSESSAO", sessao).and("pcCodPessoa", pessoa.getCodPessoa()).and("pcClienteAtivo", "S")
				.and("pcCodClienteXP", customerXP.getPersonCustomerCode()).and("pcCpf", pessoa.getDocumentoPrincipal().getNumero())
				.and("pcNome", customerXP.getPersonName()).and("pdDataNascimento", customerXP.getPersonBirthdate())
				.and("pcEstadoCivil", customerXP.getPersonMaritalStatus())
				.and("pnSalario", customerXP.getFinancialSalary()).and("pcCodProfissao", customerXP.getProfessionId())
				.and("pcCodAreaFixo", customerXP.getTelephoneAreaCode())
				.and("pcNumTelefoneFixo", customerXP.getTelephoneNumber())
				.and("pcCodAreaCel", customerXP.getCellPhoneAreaCode())
				.and("pcNumTelefoneCel", customerXP.getCellPhoneNumber()).and("pcEmail", customerXP.getPersonEmail())
				.and("pcCargo", customerXP.getProfessionDescription())
				.and("pcOrgao", customerXP.getPoliticallyExposedAgency())
				.and("pdDataNomeacao", customerXP.getPoliticallyExposedStartDate())
				.and("pdDataExoneracao", customerXP.getPoliticallyExposedExpirationDate())
				.and("pnNIF", customerXP.getTaxIdentifierNumber())
				.and("pnGreenCard", customerXP.getUsPersonGreenCardNumber())
				.and("pnSSN", customerXP.getUsPersonSocialSecurityNumber())
				.and("pcLogradouroRes", customerXP.getResidentialAddressStreet())
				.and("pcNumeroRes", customerXP.getResidentialAddressNumber())
				.and("pcComplementoRes", customerXP.getResidentialAddressComplementation())
				.and("pcBairroRes", customerXP.getResidentialAddressNeighborhood())
				.and("pcCidadeRes", customerXP.getResidentialAddressCity())
				.and("pcCepRes", customerXP.getResidentialAddressZipCode())
				.and("pcEstadoRes", customerXP.getResidentialAddressFederalUnit())
				.and("pcLogradouroCom", customerXP.getCommercialAddressStreet())
				.and("pcNumeroCom", customerXP.getCommercialAddressNumber())
				.and("pcComplementoCom", customerXP.getCommercialAddressComplementation())
				.and("pcBairroCom", customerXP.getCommercialAddressNeighborhood())
				.and("pcCidadeCom", customerXP.getCommercialAddressCity())
				.and("pcCepCom", customerXP.getCommercialAddressZipCode())
				.and("pcEstadoCom", customerXP.getCommercialAddressFederalUnit())
				.and("pcLogradouroFis", customerXP.getTaxAddressStreet())
				.and("pcNumeroFis", customerXP.getTaxAddressNumber())
				.and("pcComplementoFis", customerXP.getTaxAddressComplementation())
				.and("pcBairroFis", customerXP.getTaxAddressNeighborhood())
				.and("pcCidadeFis", customerXP.getTaxAddressCity()).and("pcCepFis", customerXP.getTaxAddressZipCode())
				.and("pcEstadoFis", customerXP.getTaxAddressFederalUnit()).and("pcSexo", customerXP.getGender()));
	}

	private StoredProcedureQuery registraProcedure() {
		return dao.registerProcedure(" kpvcust11.pck_db_ki_xp_int029.p_atualiza_pessoa",
				with("PCCODEMPRESA", String.class).and("PNSESSAO", Integer.class).and("pcCodPessoa", String.class)
						.and("pcClienteAtivo", String.class).and("pcCodClienteXP", String.class)
						.and("pcCpf", String.class).and("pcNome", String.class).and("pdDataNascimento", Date.class)
						.and("pcEstadoCivil", String.class).and("pnSalario", Double.class)
						.and("pcCodProfissao", String.class).and("pcCodAreaFixo", String.class)
						.and("pcNumTelefoneFixo", String.class).and("pcCodAreaCel", String.class)
						.and("pcNumTelefoneCel", String.class).and("pcEmail", String.class).and("pcCargo", String.class)
						.and("pcOrgao", String.class).and("pdDataNomeacao", Date.class)
						.and("pdDataExoneracao", Date.class).and("pnNIF", String.class).and("pnGreenCard", String.class)
						.and("pnSSN", String.class).and("pcLogradouroRes", String.class)
						.and("pcNumeroRes", String.class).and("pcComplementoRes", String.class)
						.and("pcBairroRes", String.class).and("pcCidadeRes", String.class).and("pcCepRes", String.class)
						.and("pcEstadoRes", String.class).and("pcLogradouroCom", String.class)
						.and("pcNumeroCom", String.class).and("pcComplementoCom", String.class)
						.and("pcBairroCom", String.class).and("pcCidadeCom", String.class).and("pcCepCom", String.class)
						.and("pcEstadoCom", String.class).and("pcLogradouroFis", String.class)
						.and("pcNumeroFis", String.class).and("pcComplementoFis", String.class)
						.and("pcBairroFis", String.class).and("pcCidadeFis", String.class).and("pcCepFis", String.class)
						.and("pcEstadoFis", String.class).and("pcSexo", String.class));
	}

	private List<Customer> buscaAtualizacaoPessoasXP(String urlAtualizaClienteXP, List<Pessoa> listaPessoasKiprev) {

		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		listaPessoasKiprev.stream().forEach(p -> arrayBuilder.add(Long.valueOf(p.getDocumentoPrincipal().getNumero())));

		Map<String, Object> headers = Maps.newHashMap();
		headers.put(CONTENT_TYPE, APPLICATION_JSON);
		headers.put(ACCEPT, APPLICATION_JSON);

		List<?> filtros = Lists.newArrayList(new ClienteRestLogger(Interface.ATUALIZA_CLIENTES));
		Response jsonResponse = clienteRestService.post(urlAtualizaClienteXP, Entity.json(arrayBuilder.build()),
				headers, filtros);

		if (!jsonResponse.getStatusInfo().getFamily().equals(Family.SUCCESSFUL)) {
			throw new NegocioException(
					jsonResponse.getStatusInfo().getReasonPhrase() + " - " + jsonResponse.readEntity(String.class));
		}

		return Arrays.asList(jsonResponse.readEntity(Customer[].class));
	}

	private void logMonitor(Integer sessao, String msg) {
		try {
			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int029.p_log_erro",
					with("pnSessao", sessao).and("pcMsgErro", msg));
		} catch (Exception e) {
			logger.error("Erro ao tentar logar no Monitor", e);
		}
	}

}
