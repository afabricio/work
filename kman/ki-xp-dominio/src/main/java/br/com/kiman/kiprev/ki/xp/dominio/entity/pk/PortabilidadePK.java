package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;

public class PortabilidadePK implements Serializable {

	private static final long serialVersionUID = 7378706181734338460L;
	private String codEmpresa;
	private String numPortabilidade;

	public PortabilidadePK() {
		this.codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	}

	public PortabilidadePK(String numPortabilidade) {
		this();
		this.numPortabilidade = numPortabilidade;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getNumPortabilidade() {
		return numPortabilidade;
	}

	public void setNumPortabilidade(String numPortabilidade) {
		this.numPortabilidade = numPortabilidade;
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
