package br.com.kiman.kiprev.ki.xp.dominio.facade;

import static br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum.DEFAULT_COMPANY;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;

import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestService;
import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dto.DocumentorRelatorioDTO;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Conta;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Portabilidade;
import br.com.kiman.kiprev.ki.xp.dominio.entity.SolicitacaoPortabilidade;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Proposta;
import br.com.kiman.kiprev.ki.xp.dominio.entity.Transferencia;
import br.com.kiman.kiprev.ki.xp.dominio.entity.SolicitacaoTransferencia;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaPK;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PortabilidadePK;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PropostaPK;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.TransferenciaPK;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.dao.JPQLs;
import br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters;

@Stateless
public class DocumentoRelatorioFacade {

	public static final String EJB_NAME = "ejb/DocumentoRelatorioFacade";

	private static final String ERRO_AO_RECUPERAR_ARQUIVO = "Não foi possível recuperar o documento.";
	private static final String REL_PROP = "%s?NOME_RELATORIO=AFPROP1&COD_EMPRESA=%s&NUM_FORMULARIO=%s";
	private static final String REL_CERTIF = "%s?NOME_RELATORIO=FOCTCERT&COD_EMPRESA=%s&COD_CUENTA=%s";
	private static final String REL_PORTAB = "%s?NOME_RELATORIO=FOPORTER&COD_EMPRESA=%s&NUM_PORTABILIDADE=%s";
	private static final String REL_TRANSF = "%s?NOME_RELATORIO=FOTRISCF&COD_EMPRESA=%s&NUM_TRANSFERENCIA=%s";

	private static final Logger logger = Logger.getLogger(DocumentoRelatorioFacade.class);

	@Inject
	private GenericDAO dao;
	@Inject
	private ClienteRestService restService;

	private String buscaUrlRelatorio() {
		return dao.buscaUrlJasper();
	}

	public DocumentorRelatorioDTO documentoProposta(Long numProposta) {
		Proposta proposta = dao.find(new PropostaPK(numProposta), Proposta.class);
		if (proposta == null) {
			throw new NegocioException("Proposta não encontrada.");
		}

		String url = String.format(REL_PROP, buscaUrlRelatorio(), DEFAULT_COMPANY.getValue(), numProposta);

		DocumentorRelatorioDTO documentoPropostaDTO = new DocumentorRelatorioDTO();
		documentoPropostaDTO.setDocumentoBase64(getRelatorio(url));
		documentoPropostaDTO.setNumPortabilidades(proposta.getSolicPortabilidades().stream()
				.map(p -> p.getNumPortabilidade()).collect(Collectors.toList()));
		documentoPropostaDTO.setNumTransferencias(proposta.getSolicTransferencias().stream()
				.map(t -> t.getNumTransferencia()).collect(Collectors.toList()));
		return documentoPropostaDTO;
	}

	public DocumentorRelatorioDTO documentoCertificado(String numCertificado) {
		Conta conta = dao.find(new ContaPK(numCertificado), Conta.class);
		if (conta == null) {
			throw new NegocioException("Certificado não encontrada.");
		}

		String url = String.format(REL_CERTIF, buscaUrlRelatorio(), DEFAULT_COMPANY.getValue(), numCertificado);

		DocumentorRelatorioDTO documentoPropostaDTO = new DocumentorRelatorioDTO();
		documentoPropostaDTO.setDocumentoBase64(getRelatorio(url));
		documentoPropostaDTO.setNumPortabilidades(
				conta.getPortabilidades().stream().map(p -> p.getNumPortabilidade()).collect(Collectors.toList()));
		documentoPropostaDTO.setNumTransferencias(
				conta.getTransferencias().stream().map(t -> t.getNumTransferencia()).collect(Collectors.toList()));
		return documentoPropostaDTO;
	}

	public DocumentorRelatorioDTO documentoPortabilidade(String numPortabilidade) {

		Portabilidade portab = dao.find(new PortabilidadePK(numPortabilidade), Portabilidade.class);
		QueryParameters qp = QueryParameters.with("codEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue())
                .and("numPortabilidade", numPortabilidade);
		List<SolicitacaoPortabilidade> solicPortab = dao.findByNamedQuery(JPQLs.N_SOLICITACAO_PORTABILIDADE,qp);
		if (portab == null && solicPortab.isEmpty()) {
			throw new NegocioException("Portabilidade não encontrada.");
		}
		String url = String.format(REL_PORTAB, buscaUrlRelatorio(), DEFAULT_COMPANY.getValue(), numPortabilidade);

		DocumentorRelatorioDTO documentoPropostaDTO = new DocumentorRelatorioDTO();
		documentoPropostaDTO.setDocumentoBase64(getRelatorio(url));
		return documentoPropostaDTO;
	}

	public DocumentorRelatorioDTO documentoTransferencia(Long numTransferencia) {
		Transferencia tranf = dao.find(new TransferenciaPK(numTransferencia), Transferencia.class);
		QueryParameters qp = QueryParameters.with("codEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue())
                                            .and("numTransferencia", numTransferencia);
		List<SolicitacaoTransferencia> solicTransf = dao.findByNamedQuery(JPQLs.N_SOLICITACAO_TRANSFERENCIA,qp);
		if (tranf == null && solicTransf.isEmpty()) {
			throw new NegocioException("Transferência não encontrada.");
		}
		String url = String.format(REL_TRANSF, buscaUrlRelatorio(), DEFAULT_COMPANY.getValue(), numTransferencia);

		DocumentorRelatorioDTO documentoPropostaDTO = new DocumentorRelatorioDTO();
		documentoPropostaDTO.setDocumentoBase64(getRelatorio(url));
		return documentoPropostaDTO;
	}

	private String getRelatorio(String url) {
		Response response = restService.get(url);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error(ERRO_AO_RECUPERAR_ARQUIVO);
			logger.error(response.readEntity(String.class));
			throw new NegocioException(ERRO_AO_RECUPERAR_ARQUIVO);
		}
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			FileCopyUtils.copy(response.readEntity(InputStream.class), out);
			String arquivoBase64 = Base64.encodeBase64String(out.toByteArray());
			out.close();
			return arquivoBase64;
		} catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

}
