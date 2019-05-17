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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ProdutoBeneficioPK;

@IdClass(ProdutoBeneficioPK.class)
@Entity
@Table(schema = "KIPREV", name = "BE_BENEFICIOS_X_PRODUTO")
//@NamedNativeQuery(name = JPQLs.N_COD_PRODUTO_GERENCIAL, query = JPQLs.Q_COD_PRODUTO_GERENCIAL)
public class ProdutoBeneficio {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_PRODUTO")
	private String codProduto;
	@Id
	@Column(name = "COD_BENEFICIO")
	private Long codBeneficio;
	@Id
	@Column(name = "COD_PLAN")
	private Long codPlano;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false) })
	private Beneficio beneficio;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public Long getCodBeneficio() {
		return codBeneficio;
	}

	public void setCodBeneficio(Long codBeneficio) {
		this.codBeneficio = codBeneficio;
	}

	public Long getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(Long codPlano) {
		this.codPlano = codPlano;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public boolean isBeneficioSobrevivencia() {
		return beneficio.isSobrevivencia();
	}

	public void getContribuicaoRegular() {

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProdutoBeneficio) {
			ProdutoBeneficio p = (ProdutoBeneficio) obj;
			return new EqualsBuilder().append(codEmpresa, p.codEmpresa)
					.append(codProduto, p.codProduto)
					.append(codBeneficio, p.codBeneficio)
					.append(codPlano, p.codPlano).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codProduto)
				.append(codBeneficio).append(codPlano).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(codEmpresa).append(codProduto).append(codBeneficio)
				.append(codPlano).build();
	}

}
