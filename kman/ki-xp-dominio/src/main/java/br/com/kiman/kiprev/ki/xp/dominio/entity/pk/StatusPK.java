package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StatusPK implements Serializable {

	private static final long serialVersionUID = -7533922395913421833L;
	private String codTipoStatus;
	private String codStatus;

	public String getCodTipoStatus() {
		return codTipoStatus;
	}

	public void setCodTipoStatus(String codTipoStatus) {
		this.codTipoStatus = codTipoStatus;
	}

	public String getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(String codStatus) {
		this.codStatus = codStatus;
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
