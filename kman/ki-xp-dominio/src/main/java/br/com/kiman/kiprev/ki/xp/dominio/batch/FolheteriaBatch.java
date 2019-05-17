package br.com.kiman.kiprev.ki.xp.dominio.batch;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;

import com.google.common.collect.Lists;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;
import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestLogger;
import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestService;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters;
import br.com.kiman.kiprev.ki.xp.dominio.entity.FolheteriaAnexo;
import br.com.kiman.kiprev.ki.xp.dominio.entity.FolheteriaDeta;
import br.com.kiman.kiprev.ki.xp.dominio.entity.FolheteriaEnca;
import br.com.kiman.kiprev.ki.xp.dominio.exception.BatchException;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Attachment;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Beneficiary;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Certificate;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.CertificateBalance;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.FinancialTransaction;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Insured;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.InsuredDataModel;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.InvestmentFunds;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.PaymentData;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Plan;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Portability;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.Proposal;
import br.com.kiman.kiprev.ki.xp.integration.folheterias.UpdateInfo;

@Stateless
@Batch(name = "DOCTO-ENV-FOLHETERIA-XP")
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class FolheteriaBatch implements BatchInterface {

	@Inject
	private GenericDAO dao;

	@Inject
	private ParametroBean parametroService;

	private static final Logger logger = Logger.getLogger(FolheteriaBatch.class);

	@Override
	public BatchResult execute() {

		try {
			InsuredDataModel insuredDataModel = new InsuredDataModel();

			List<FolheteriaEnca> listaFolheteria = dao.findByNamedQuery(FolheteriaEnca.QUERY_FIND_ALL_NOTSENT);

			listaFolheteria.stream().forEach(enca -> {

				List<FolheteriaDeta> detaNaoEnviados = dao.findByNamedQuery(
						FolheteriaDeta.QUERY_FIND_ALL_NOTSENT_BY_ENCA,
						QueryParameters.with("pIdEnca", enca.getIdEnca()));

				int countSuccess = 0;
				for (FolheteriaDeta deta : detaNaoEnviados) {

					try {
						insuredDataModel.setCertificate(buildCertificate(deta));
						insuredDataModel.setProposal(buildProposal(deta));
						insuredDataModel.setUpdatedItems(buildUpdatedItems(deta));
						insuredDataModel.setAttachments(buildAttachments(deta));

						if (callFolheteriaXPService(insuredDataModel)) {
							deta.setStatusGer("S");
							dao.update(deta);
							countSuccess++;
						}

					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						deta.setStatusGer("E");
						dao.update(deta);
					}

				}
				if (countSuccess == detaNaoEnviados.size()) {
					enca.setStatusGer("S");
					dao.update(enca);
				}
			});

			return BatchResult.SUCESSO;

		} catch (Exception e) {

			String emsg = "Erro ao executar o batch de fundos de investimentos";
			logger.error(emsg,e);

			throw new BatchException(emsg, e);
		}

	}

	private Certificate buildCertificate(FolheteriaDeta deta) {

		Certificate certificate = new Certificate();

		certificate.setBalances(deta.getFolheteriaReservaFuns().stream().map(r -> {

			CertificateBalance balance = new CertificateBalance();
			balance.setValue(r.getVlrSaldo());
			balance.setQuotaQuantity(r.getQtdCota());
			balance.setQuotaValue(r.getVlrUnitCota());
			balance.investmentFundDocument(r.getCnpjFundo());

			return balance;

		}).collect(Collectors.toList()));
		certificate.setTotalBalance(deta.getVlrTotalFundo());

		certificate.setCertificateCode(deta.getCodCertificado());
		certificate.setCertificateStatus(deta.getStatusCertificado());
		certificate.setCertificateStatusDate(deta.getDataStatusCertificado());
		certificate.setContributionReport("S".equals(deta.getIndRelContrib()));
		certificate.setTaxReturnReport("S".equals(deta.getIndInfRendimentos()));

		List<Beneficiary> beneficiariesCertificate = deta.getFolheteriaBenefs().stream()
				.filter(b -> "C".equals(b.getTipoRegistro())).map(benefEntity -> {

					Beneficiary beneficiary = new Beneficiary();

					beneficiary.setBeneficiaryName(benefEntity.getNomeBeneficiario());
					beneficiary.setParticipationPercentage(benefEntity.getPercentParticipacao());
					beneficiary.setRelationshipDegree(benefEntity.getGrauParentesco());

					return beneficiary;

				}).collect(Collectors.toList());

		certificate.setBeneficiaries(beneficiariesCertificate);

		List<FinancialTransaction> listFinancialTransactions = deta.getFolheteriaTransFinans().stream()
				.map(transFinanEntity -> {
					FinancialTransaction financialTransaction = new FinancialTransaction();

					PaymentData paymentData = new PaymentData();

					paymentData.setPaymentMethod(transFinanEntity.getMetodoPagto());
					paymentData.setPaymentType(transFinanEntity.getTipoPagto());
					paymentData.setRequestDate(transFinanEntity.getDataInclusao());
					paymentData.setSettlementDate(transFinanEntity.getDataVencto());
					paymentData.setValue(transFinanEntity.getValorPagto());

					financialTransaction.setPaymentData(paymentData);
					financialTransaction.setTransactionId(transFinanEntity.getIdTransacao());
					financialTransaction.setTransactionStatus(transFinanEntity.getStatusTransacao());
					financialTransaction.setTransactionStatusDate(transFinanEntity.getDataStatusTransacao());
					financialTransaction.setTransactionType(transFinanEntity.getTipoTransacao());

					return financialTransaction;

				}).collect(Collectors.toList());

		certificate.setFinancialTransactions(listFinancialTransactions);

		PaymentData paymentData = new PaymentData();
		paymentData.setPaymentMethod(deta.getMetodoPagtoCert());
		paymentData.setPaymentType(deta.getTipoPagtoCert());
		paymentData.setRequestDate(deta.getDataSolicCert());
		paymentData.setSettlementDate(deta.getDataVenctoCert());
		paymentData.setValue(deta.getValorPagtoCert());

		paymentData.setInvestmentFunds(
				deta.getFolheteriaDistribFuns().stream().filter(f -> f.getTipoRegistro().equals("CE")).map(f -> {

					return f.getCnpjFundo();

				}).collect(Collectors.toList()));

//
//		paymentData.setInvestmentFunds(deta.getFolheteriaTransFinans().stream().map(f -> {
//
//			return f.getFolheteriaContribFuns().stream().map(fund -> fund.getCnpjFundo()).collect(Collectors.toList());
//
//		}).flatMap(List::stream).collect(Collectors.toList()));

		certificate.setPaymentData(paymentData);

		return certificate;

	}

	private Proposal buildProposal(FolheteriaDeta deta) {

		Proposal proposal = new Proposal();

		proposal.setProposalCode(deta.getCodProposta().toString());
		proposal.setProposalStatus(deta.getStatusProposta());
		proposal.setProposalStatusDate(deta.getDataStatusProposta());

		List<Beneficiary> beneficiariesProposal = deta.getFolheteriaBenefs().stream()
				.filter(b -> "P".equals(b.getTipoRegistro())).map(benefEntity -> {

					Beneficiary beneficiary = new Beneficiary();

					beneficiary.setBeneficiaryName(benefEntity.getNomeBeneficiario());
					beneficiary.setParticipationPercentage(benefEntity.getPercentParticipacao());
					beneficiary.setRelationshipDegree(benefEntity.getGrauParentesco());

					return beneficiary;
				}).collect(Collectors.toList());

		proposal.setBeneficiaries(beneficiariesProposal);

		Insured insured = new Insured();
		insured.setDocument(Long.valueOf(deta.getDocumento()));
		insured.setEmail(deta.getEmail());
		insured.setMainPhone(deta.getTelPrincipal());
		insured.setName(deta.getNome());
		insured.setSecondaryPhone(deta.getTelSecundario());
		proposal.setInsured(insured);

		PaymentData paymentData = new PaymentData();
		paymentData.setPaymentMethod(deta.getMetodoPagtoProp());
		paymentData.setPaymentType(deta.getTipoPagtoProp());
		paymentData.setRequestDate(deta.getDataSolicProp());
		paymentData.setSettlementDate(deta.getDataVenctoProp());
		paymentData.setValue(deta.getValorPagtoProp());

		deta.getFolheteriaTransFinans().stream().map(f -> {

			return f.getFolheteriaContribFuns().stream().map(fund -> fund.getCnpjFundo()).collect(Collectors.toList());

		}).collect(Collectors.toList());

		paymentData.setInvestmentFunds(
				deta.getFolheteriaDistribFuns().stream().filter(f -> f.getTipoRegistro().equals("PR")).map(f -> {

					return f.getCnpjFundo();

				}).collect(Collectors.toList()));

		proposal.setPaymentData(paymentData);

		Plan plan = new Plan();
		plan.setPlanType(deta.getModalidade());
		plan.setPlanName(deta.getNomePlano());
		plan.setSusepCode(deta.getCodSusepFundo());
		plan.setTaxOption(deta.getRegimeTributario());
		plan.setInvestmentFunds(deta.getFolheteriaFundos().stream().map(f -> {

			InvestmentFunds investmentFunds = new InvestmentFunds();

			investmentFunds.setName(f.getNomeFundo());
			investmentFunds.setDocument(f.getCnpjFundo());
			investmentFunds.setDistributionPercentage(f.getNumPercDistribuicao());

			return investmentFunds;

		}).collect(Collectors.toList()));
		proposal.setPlan(plan);

		List<Portability> portabilities = deta.getFolheteriaPortabs().stream().map(p -> {

			Portability portability = new Portability();
			portability.setPortabilityCode(p.getCodPortabilidade());
			portability.setPortabilityStatus(p.getStatusPortabilidade());
			portability.setPortabilityStatusDate(p.getDataStatusPortab());
			portability.setValue(p.getValorPortabilidade());

			Plan originPlan = new Plan();

			originPlan.setInvestmentFunds(
					p.getFolheteriaFundoPrtbs().stream().filter(f -> f.getTipoRegistro().equals("OR")).map(f -> {

						InvestmentFunds investmentFunds = new InvestmentFunds();

						investmentFunds.setName(f.getNomeFundo());
						investmentFunds.setDocument(f.getCnpjFundo());
						investmentFunds.setDistributionPercentage(f.getNumPercDistribuicao());

						return investmentFunds;

					}).collect(Collectors.toList()));

			originPlan.setPlanType(p.getModalidadeOrig());
			originPlan.setPlanName(p.getNomePlanoOrig());
			originPlan.setSusepCode(p.getCodSusepFundoOrig());
			originPlan.setTaxOption(p.getRegTributarioOrig());
			portability.setOriginPlan(originPlan);

			Plan destinationPlan = new Plan();
			destinationPlan.setInvestmentFunds(
					p.getFolheteriaFundoPrtbs().stream().filter(f -> f.getTipoRegistro().equals("DE")).map(f -> {

						InvestmentFunds investmentFunds = new InvestmentFunds();

						investmentFunds.setName(f.getNomeFundo());
						investmentFunds.setDocument(f.getCnpjFundo());
						investmentFunds.setDistributionPercentage(f.getNumPercDistribuicao());

						return investmentFunds;

					}).collect(Collectors.toList()));
			destinationPlan.setPlanType(p.getModalidadeDest());
			destinationPlan.setPlanName(p.getNomePlanoDest());
			destinationPlan.setSusepCode(p.getCodSusepFundoDest());
			destinationPlan.setTaxOption(p.getRegTributarioDest());
			portability.setDestinationPlan(destinationPlan);

			return portability;

		}).collect(Collectors.toList());

		proposal.setPortabilities(portabilities);

		return proposal;

	}

	private List<UpdateInfo> buildUpdatedItems(FolheteriaDeta deta) {

		List<UpdateInfo> updatedItems = deta.getFolheteriaAtualizacaos().stream().map(a -> {

			UpdateInfo updatedItem = new UpdateInfo();
			updatedItem.setCustomerItem(a.getCodAtualizacao());
			updatedItem.setUpdatedOn(a.getDataAtualizacao());

			return updatedItem;

		}).collect(Collectors.toList());

		return updatedItems;

	}

	private List<Attachment> buildAttachments(FolheteriaDeta deta) {

		List<Attachment> updatedItems = deta.getFolheteriaAnexos().stream().map(a -> {

			Attachment attach = new Attachment();

			attach.setFileName(a.getNomeAnexo());
			attach.setFileExtension("pdf");
			attach.setFileId(a.getIdAnexo());
			attach.setBase64(buscaArquivoURL(a));
			attach.setArchiveType(a.getTipoDocAnexado());

			return attach;

		}).collect(Collectors.toList());

		return updatedItems;

	}

	private static final String ERRO_AO_RECUPERAR_O_ARQUIVO = "Erro ao recuperar o arquivo - Id: %s - %s - Status: %s ";

	private byte[] buscaArquivoURL(FolheteriaAnexo anexo) {
		
		Response response = restService.get(anexo.getAnexo());
		if (response.getStatus() != Status.OK.getStatusCode()) {
			String mensagem = String.format(ERRO_AO_RECUPERAR_O_ARQUIVO, anexo.getId(), anexo.getAnexo(),
					response.getStatus());
			throw new NegocioException(mensagem);
		}

		InputStream in = response.readEntity(InputStream.class);

		try {
			return IOUtils.toByteArray(in);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@Inject
	private ClienteRestService restService;

	private boolean callFolheteriaXPService(InsuredDataModel insuredDataModel) throws Exception {
		String url = parametroService.buscaParametro(Interface.FOLHETERIA, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_FOLHETERIA);

		List<?> filtros = Lists.newArrayList(
				new ClienteRestLogger(Interface.FOLHETERIA, insuredDataModel.getCertificate().getCertificateCode()));

		Response response = restService.post(url, Entity.json(insuredDataModel), filtros);

		if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
			return true;
		} else {
			throw new Exception(response.getStatusInfo().getReasonPhrase());
		}

	}

}
