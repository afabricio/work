package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.BeneficioPK;

@Entity
@IdClass(BeneficioPK.class)
@Table(schema = "KIPREV", name = "BE_BENEFICIOS")
public class Beneficio {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_PLAN")
	private Long codPlano;
	@Id
	@Column(name = "COD_BENEFICIO")
	private Long codBeneficio;
	@Column(name = "DESCRIPCION")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPCOBERTURA", referencedColumnName = "COD_TIPCOBERTURA", insertable = false, updatable = false)
	private TipoCobertura tipoCobertura;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(Long codPlano) {
		this.codPlano = codPlano;
	}

	public Long getCodBeneficio() {
		return codBeneficio;
	}

	public void setCodBeneficio(Long codBeneficio) {
		this.codBeneficio = codBeneficio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(TipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public boolean isRisco() {
		return tipoCobertura != null && tipoCobertura.getIndRisco();
	}

	public boolean isSobrevivencia() {
		return !isRisco();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codPlano).append(codBeneficio)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beneficio) {
			Beneficio other = (Beneficio) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codPlano, other.codPlano)
					.append(codBeneficio, other.codBeneficio).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codPlano)
				.append(codBeneficio).build();
	}

}
