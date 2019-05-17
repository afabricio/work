package br.com.kiman.kiprev.ki.xp.jaxws.documento;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.jws.WebService;

import br.com.kiman.kiprev.ki.xp.dominio.dto.DocumentorRelatorioDTO;
import br.com.kiman.kiprev.ki.xp.dominio.facade.DocumentoRelatorioFacade;
import br.com.kiman.kiprev.ki.xp.jaxws.exception.ResourceWSException;

@WebService
public class DocumentoWSImpl implements DocumentoWS {

	@EJB(mappedName = DocumentoRelatorioFacade.EJB_NAME)
	private DocumentoRelatorioFacade facade;

	@Override
	public DocumentoPropostaResult documentoProposta(Long numProposta) {
		try {
			DocumentorRelatorioDTO documentoRelatorio = facade.documentoProposta(numProposta);
			return new DocumentoPropostaResult(documentoRelatorio);
		} catch (EJBException e) {
			throw new ResourceWSException(e.getCause().getMessage(), e.getCause());
		}
	}

	@Override
	public DocumentoCertificadoResult documentoCertificado(String numCertificado) {
		try {
			DocumentorRelatorioDTO documentoRelatorio = facade.documentoCertificado(numCertificado);
			return new DocumentoCertificadoResult(documentoRelatorio);
		} catch (EJBException e) {
			throw new ResourceWSException(e.getCause().getMessage(), e.getCause());
		}
	}

	@Override
	public DocumentoPortabilidadeResult documentoPortabilidade(String numPortabilidade) {
		try {
			DocumentorRelatorioDTO documentoRelatorio = facade.documentoPortabilidade(numPortabilidade);
			return new DocumentoPortabilidadeResult(documentoRelatorio);
		} catch (EJBException e) {
			throw new ResourceWSException(e.getCause().getMessage(), e.getCause());
		}

	}

	@Override
	public DocumentoTransferenciaResult documentoTransferencia(Long numTransferencia) {
		try {
			DocumentorRelatorioDTO documentoRelatorio = facade.documentoTransferencia(numTransferencia);
			return new DocumentoTransferenciaResult(documentoRelatorio);
		} catch (EJBException e) {
			throw new ResourceWSException(e.getCause().getMessage(), e.getCause());
		}

	}

}
