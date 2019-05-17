package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SolicitacaoPortabilidadePK implements Serializable {

	private static final long serialVersionUID = 4855824887202181550L;
	private String codEmpresa;
	private Long numFormulario;
	private Long seqPortabilidade;

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

	public Long getSeqPortabilidade() {
		return seqPortabilidade;
	}

	public void setSeqPortabilidade(Long seqPortabilidade) {
		this.seqPortabilidade = seqPortabilidade;
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
