package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ContaBancariaPK implements Serializable {

	private static final long serialVersionUID = 6462248619556546301L;

	private String codPessoa;
	private String codContaBancaria;

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCodContaBancaria() {
		return codContaBancaria;
	}

	public void setCodContaBancaria(String codContaBancaria) {
		this.codContaBancaria = codContaBancaria;
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
