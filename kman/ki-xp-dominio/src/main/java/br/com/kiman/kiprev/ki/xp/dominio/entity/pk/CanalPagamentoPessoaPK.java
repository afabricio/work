package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;

public class CanalPagamentoPessoaPK implements Serializable {

	private static final long serialVersionUID = -8776713232183385013L;
	private String codEmpresa;
	private String codCanal;
	private String codPessoa;

	public CanalPagamentoPessoaPK(String codEmpresa, String codCanal,
			String codPessoa) {
		this.codEmpresa = codEmpresa;
		this.codCanal = codCanal;
		this.codPessoa = codPessoa;
	}

	public CanalPagamentoPessoaPK(String codCanal, String codPessoa) {
		this(SystemConfEnum.DEFAULT_COMPANY.getValue(), codCanal, codPessoa);
	}

	public CanalPagamentoPessoaPK() {
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(String codCanal) {
		this.codCanal = codCanal;
	}

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
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
