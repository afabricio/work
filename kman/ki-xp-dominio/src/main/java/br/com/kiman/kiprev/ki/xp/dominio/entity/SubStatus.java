package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@IdClass(SubStatusPK.class)
@Table(name = "PA_STATUS_SUB", schema = "KIPREV")
public class SubStatus {

	@Id
	@Column(name = "TIP_STATUS")
	private String codTipoStatus;
	@Id
	@Column(name = "COD_STATUS")
	private String codStatus;
	@Id
	@Column(name = "COD_SUB_STATUS")
	private String codSubStatus;
	@Column(name = "DES_SUB_STATUS")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "TIP_STATUS", referencedColumnName = "TIP_STATUS", insertable = false, updatable = false),
			@JoinColumn(name = "COD_STATUS", referencedColumnName = "COD_STATUS", insertable = false, updatable = false) })
	private Status status;

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

	public String getCodSubStatus() {
		return codSubStatus;
	}

	public void setCodSubStatus(String codSubStatus) {
		this.codSubStatus = codSubStatus;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SubStatus) {
			SubStatus statusSub = (SubStatus) obj;
			return new EqualsBuilder()
					.append(codTipoStatus, statusSub.codTipoStatus)
					.append(codStatus, statusSub.codStatus)
					.append(codSubStatus, statusSub.codSubStatus).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codTipoStatus).append(codStatus)
				.append(codSubStatus).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codTipoStatus).append(codStatus).append(codSubStatus)
				.build();
	}
	
}
