package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.StatusPK;

@Entity
@IdClass(StatusPK.class)
@Table(name = "PA_STATUS", schema = "KIPREV")
public class Status {

	@Id
	@Column(name = "TIP_STATUS")
	private String codTipoStatus;
	@Id
	@Column(name = "COD_STATUS")
	private String codStatus;
	@Column(name = "DES_STATUS")
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codTipoStatus).append(codStatus)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Status) {
			Status status = (Status) obj;
			return new EqualsBuilder()
					.append(codTipoStatus, status.codTipoStatus)
					.append(codStatus, status.codStatus).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codTipoStatus).append(codStatus).build();
	}
}
