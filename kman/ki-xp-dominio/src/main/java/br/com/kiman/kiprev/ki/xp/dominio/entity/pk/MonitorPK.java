package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MonitorPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5776433896374104280L;
	private String session;
	private String codSubSession;
	private String codProcesso;

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getCodSubSession() {
		return codSubSession;
	}

	public void setCodSubSession(String codSubSession) {
		this.codSubSession = codSubSession;
	}

	public String getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(String codProcesso) {
		this.codProcesso = codProcesso;
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
