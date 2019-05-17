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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PropostaBeneficioPK;

@Entity
@IdClass(PropostaBeneficioPK.class)
@Table(schema = "KIPREV", name = "AF_BENEFICIOS_X_SOLICITACAO")
public class PropostaBeneficio {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_AGENCIA")
	private String codAgencia;
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Id
	@Column(name = "COD_PRODUTO")
	private String codProduto;
	@Id
	@Column(name = "COD_PLAN")
	private Long codPlano;
	@Id
	@Column(name = "COD_BENEFICIO")
	private Long codBeneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false) })
	private Beneficio beneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "TIP_PAGO", referencedColumnName = "TIP_PAGO", insertable = false, updatable = false) })
	private TipoPagamentoBeneficio tipoPagamentoBeneficio;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodAgencia() {
		return codAgencia;
	}

	public void setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}

	public Long getNumFormulario() {
		return numFormulario;
	}

	public void setNumFormulario(Long numFormulario) {
		this.numFormulario = numFormulario;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
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

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public TipoPagamentoBeneficio getTipoPagamentoBeneficio() {
		return tipoPagamentoBeneficio;
	}

	public void setTipoPagamentoBeneficio(
			TipoPagamentoBeneficio tipoPagamentoBeneficio) {
		this.tipoPagamentoBeneficio = tipoPagamentoBeneficio;
	}

	public boolean isSobrevivencia() {
		return beneficio != null && beneficio.isSobrevivencia();
	}

	public boolean isRisco() {
		return beneficio != null && beneficio.isRisco();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropostaBeneficio) {
			PropostaBeneficio other = (PropostaBeneficio) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codAgencia, other.codAgencia)
					.append(numFormulario, other.numFormulario)
					.append(codProduto, other.codProduto)
					.append(codPlano, other.codPlano)
					.append(codBeneficio, other.codBeneficio).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codAgencia)
				.append(numFormulario).append(codProduto).append(codPlano)
				.append(codBeneficio).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codAgencia).append(numFormulario)
				.append(codProduto).append(codPlano).append(codBeneficio)
				.build();
	}

}
