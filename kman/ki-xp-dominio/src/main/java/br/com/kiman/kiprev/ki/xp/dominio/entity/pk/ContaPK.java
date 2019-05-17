package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;

public class ContaPK implements Serializable {

	private static final long serialVersionUID = 2259016100639342463L;
	private String codEmpresa;
	private String codConta;

	public ContaPK() {
		this.codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	}
	
	public ContaPK(String codConta) {
		this();
		this.codConta = codConta;
	}

	public ContaPK(String codEmpresa, String codConta) {
		this.codEmpresa = codEmpresa;
		this.codConta = codConta;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
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
