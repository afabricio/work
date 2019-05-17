package br.com.kiman.kiprev.ki.xp.jaxws.documento;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.kiman.kiprev.ki.xp.dominio.dto.DocumentorRelatorioDTO;

@XmlRootElement
public class DocumentoPortabilidadeResult {

	@XmlTransient
	private DocumentorRelatorioDTO documentoRelatorio;

	public DocumentoPortabilidadeResult() {
		this.documentoRelatorio = new DocumentorRelatorioDTO();
	}

	public DocumentoPortabilidadeResult(DocumentorRelatorioDTO documentoRelatorio) {
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
}
