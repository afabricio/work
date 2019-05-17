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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.RamoSeguroPK;

@IdClass(RamoSeguroPK.class)
@Entity
@Table(schema = "KIPREV", name = "PA_RAMOS_SEGURO")
public class RamoSeguro {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_RAMO")
	private Integer codRamo;

	@Column(name = "COD_GRUPO_RAMO")
	private Integer grupoRamo;

	@Column(name = "DESCRICAO")
	private String descricao;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Integer getCodRamo() {
		return codRamo;
	}

	public void setCodRamo(Integer codRamo) {
		this.codRamo = codRamo;
	}

	public Integer getGrupoRamo() {
		return grupoRamo;
	}

	public void setGrupoRamo(Integer grupoRamo) {
		this.grupoRamo = grupoRamo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RamoSeguro) {
			RamoSeguro other = (RamoSeguro) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codRamo, other.codRamo).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codRamo).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(codEmpresa).append(codRamo).build();
	}
}
