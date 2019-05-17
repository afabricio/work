package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;

public class PropostaPK implements Serializable {

	private static final long serialVersionUID = -1905156211370264716L;
	private String codEmpresa;
	private Long numFormulario;

	public PropostaPK() {
		this.codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	}

	public PropostaPK(Long numFormulario) {
		this();
		this.numFormulario = numFormulario;
	}

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

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
