package br.com.kiman.kiprev.ki.xp.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://jaxws.xp.ki.kiprev.kiman.com.br/", name = "AssinaturaTermoPropostaResult")
public class AssinaturaTermoPropostaResult {
	private String numProposta;
	private String numCertificado;
	private String numPortabilidade;
	private String numTransferencia;
	private String indValidado;
	private String indEfetivado;
	private String msgRetorno;
	public String getNumProposta() {
		return numProposta;
	}
	public void setNumProposta(String numProposta) {
		this.numProposta = numProposta;
	}
	public String getNumCertificado() {
		return numCertificado;
	}
	public void setNumCertificado(String numCertificado) {
		this.numCertificado = numCertificado;
	}
	public String getNumPortabilidade() {
		return numPortabilidade;
	}
	public void setNumPortabilidade(String numPortabilidade) {
		this.numPortabilidade = numPortabilidade;
	}
	public String getNumTransferencia() {
		return numTransferencia;
	}
	public void setNumTransferencia(String numTransferencia) {
		this.numTransferencia = numTransferencia;
	}
	public String getIndValidado() {
		return indValidado;
	}
	public void setIndValidado(String indValidado) {
		this.indValidado = indValidado;
	}
	public String getIndEfetivado() {
		return indEfetivado;
	}
	public void setIndEfetivado(String indEfetivado) {
		this.indEfetivado = indEfetivado;
	}
	public String getMsgRetorno() {
		return msgRetorno;
	}
	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}

}
