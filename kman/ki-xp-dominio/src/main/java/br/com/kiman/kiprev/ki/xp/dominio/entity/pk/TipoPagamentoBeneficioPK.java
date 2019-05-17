package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TipoPagamentoBeneficioPK implements Serializable {
	
	private static final long serialVersionUID = -2440136664274998411L;
	private String codEmpresa;
	private Long codTipoPagamento;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getCodTipoPagamento() {
		return codTipoPagamento;
	}

	public void setCodTipoPagamento(Long codTipoPagamento) {
		this.codTipoPagamento = codTipoPagamento;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
