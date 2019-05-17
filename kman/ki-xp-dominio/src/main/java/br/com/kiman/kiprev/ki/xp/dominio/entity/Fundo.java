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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FundoPK;

@IdClass(FundoPK.class)
@Entity
@Table(name = "FO_INVERSIONES", schema = "KIPREV")
public class Fundo {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_INVERSION")
	private String codFundo;
	@Column(name = "DESCRIPCION")
	private String descFundo;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodFundo() {
		return codFundo;
	}

	public void setCodFundo(String codFundo) {
		this.codFundo = codFundo;
	}

	public String getDescFundo() {
		return descFundo;
	}

	public void setDescFundo(String descFundo) {
		this.descFundo = descFundo;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codFundo)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fundo) {
			Fundo other = (Fundo) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codFundo, other.codFundo).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codFundo).build();
	}

}
