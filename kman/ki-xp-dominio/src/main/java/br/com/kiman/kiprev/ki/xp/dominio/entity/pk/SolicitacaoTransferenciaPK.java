package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SolicitacaoTransferenciaPK implements Serializable {

	private static final long serialVersionUID = 2923606554557868048L;
	private String codEmpresa;
	private Long numFormulario;
	private Long seqTransferencia;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getNumFormulario() {
		return numFormulario;
	}

	public void setNumFormulario(Long numFormulario) {
		this.numFormulario = numFormulario;
	}

	public Long getSeqTransferencia() {
		return seqTransferencia;
	}

	public void setSeqTransferencia(Long seqTransferencia) {
		this.seqTransferencia = seqTransferencia;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
