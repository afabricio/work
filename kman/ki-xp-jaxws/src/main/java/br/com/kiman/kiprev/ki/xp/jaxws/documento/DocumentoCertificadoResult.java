package br.com.kiman.kiprev.ki.xp.jaxws.documento;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.kiman.kiprev.ki.xp.dominio.dto.DocumentorRelatorioDTO;

@XmlRootElement
public class DocumentoCertificadoResult {

	@XmlTransient
	private DocumentorRelatorioDTO documentoRelatorio;

	public DocumentoCertificadoResult() {
		this.documentoRelatorio = new DocumentorRelatorioDTO();
	}

	public DocumentoCertificadoResult(DocumentorRelatorioDTO documentoRelatorio) {
		this();
		if (documentoRelatorio != null) {
			this.documentoRelatorio = documentoRelatorio;
		}
	}

	public String getDocumentoBase64() {
		return documentoRelatorio.getDocumentoBase64();
	}

	public void setDocumentoBase64(String documentoBase64) {
		documentoRelatorio.setDocumentoBase64(documentoBase64);
	}

	public List<String> getNumPortabilidades() {
		return documentoRelatorio.getNumPortabilidades();
	}

	public void setNumPortabilidades(List<String> numPortabilidades) {
		documentoRelatorio.setNumPortabilidades(numPortabilidades);
	}

	public List<Long> getNumTransferencias() {
		return documentoRelatorio.getNumTransferencias();
	}

	public void setNumTransferencias(List<Long> numTransferencias) {
		documentoRelatorio.setNumTransferencias(numTransferencias);
	}

}
