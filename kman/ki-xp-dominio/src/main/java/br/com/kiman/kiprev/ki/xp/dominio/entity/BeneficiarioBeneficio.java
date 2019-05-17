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

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoBeneficiarioEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.BeneficiarioBeneficioPK;

@Entity
@IdClass(BeneficiarioBeneficioPK.class)
@Table(schema = "KIPREV", name = "FO_BENEFS_X_BENEFICIO_CTA")
public class BeneficiarioBeneficio {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;

	@Id
	@Column(name = "COD_CONTA")
	private String codConta;

	@Id
	@Column(name = "TIPO_BENEFICIARIO")
	private String tipoBeneficiario;

	@Id
	@Column(name = "COD_PESSOA")
	private String codPessoa;

	@Id
	@Column(name = "COD_PLAN")
	private Long codPlano;

	@Id
	@Column(name = "COD_BENEFICIO")
	private Long codBeneficio;

	@Column(name = "PCT_DISTRIBUICAO")
	private Double percentualDistribuicao;

	@Column(name = "MG_REMESSA_LINHA")
	private String remessaLinha;

	@Column(name = "STATUS")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false),
			@JoinColumn(name = "TIPO_BENEFICIARIO", referencedColumnName = "TIPO_BENEFICIARIO", insertable = false, updatable = false) })
	private BeneficiarioConta beneficiarioCertificado;

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public BeneficiarioBeneficio() {
		super();
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public TipoBeneficiarioEnum getTipoBeneficiario() {
		return TipoBeneficiarioEnum.getEnum(tipoBeneficiario);
	}

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
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

	public Double getPercentualDistribuicao() {
		return percentualDistribuicao;
	}

	public void setPercentualDistribuicao(Double percentualDistribuicao) {
		this.percentualDistribuicao = percentualDistribuicao;
	}

	public String getRemessaLinha() {
		return remessaLinha;
	}

	public void setRemessaLinha(String remessaLinha) {
		this.remessaLinha = remessaLinha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BeneficiarioConta getBeneficiarioCertificado() {
		return beneficiarioCertificado;
	}

	public void setBeneficiarioCertificado(
			BeneficiarioConta beneficiarioCertificado) {
		this.beneficiarioCertificado = beneficiarioCertificado;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beneficio) {
			BeneficiarioBeneficio other = (BeneficiarioBeneficio) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta)
					.append(tipoBeneficiario, other.tipoBeneficiario)
					.append(codPessoa, other.codPessoa)
					.append(codPlano, other.codPlano)
					.append(codBeneficio, other.codBeneficio).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.append(tipoBeneficiario).append(codPessoa).append(codPlano)
				.append(codBeneficio).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).append(tipoBeneficiario)
				.append(codPessoa).append(codPlano).append(codBeneficio)
				.build();
	}

	public String getDescricaoParentesco() {
		return beneficiarioCertificado != null ? beneficiarioCertificado
				.getDescricaoParentesco() : null;
	}

}
