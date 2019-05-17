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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.BeneficiarioContaPK;

@Entity
@IdClass(BeneficiarioContaPK.class)
@Table(schema = "KIPREV", name = "FO_BENEFS_X_CUENTA")
public class BeneficiarioConta {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Id
	@Column(name = "TIPO_BENEFICIARIO")
	private String tipoBeneficiario;
	@Id
	@Column(name = "COD_PERSONA")
	private String codPessoa;
	@Column(name = "PCT_DISTRIBUCION")
	private Long percentualDistribuicao;
	@Column(name = "COD_PARENTESCO")
	private Long codParentesco;
	@Column(name = "CONDICION_PAGO")
	private String condicaoPagamento;
	@Column(name = "FORMA_PAGO")
	private String formaPagamento;
	@Column(name = "NOMBRE_PAGO")
	private String nomePagamento;
	@Column(name = "DIREC_ENVIO_PAGO")
	private String enderecoPagamento;
	@Column(name = "DEB_AUT_CTA_PAGO")
	private String contaBancaria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PARENTESCO", referencedColumnName = "PARENTEZCO", insertable = false, updatable = false)
	private Parentesco parentesco;

	public BeneficiarioConta() {
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	public String getTipoBeneficiario() {
		return tipoBeneficiario;
	}

	public void setTipoBeneficiario(String tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public Long getPercentualDistribuicao() {
		return percentualDistribuicao;
	}

	public void setPercentualDistribuicao(Long percentualDistribuicao) {
		this.percentualDistribuicao = percentualDistribuicao;
	}

	public Long getCodParentesco() {
		return codParentesco;
	}

	public void setCodParentesco(Long codParentesco) {
		this.codParentesco = codParentesco;
	}

	public String getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(String condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getNomePagamento() {
		return nomePagamento;
	}

	public void setNomePagamento(String nomePagamento) {
		this.nomePagamento = nomePagamento;
	}

	public String getEnderecoPagamento() {
		return enderecoPagamento;
	}

	public void setEnderecoPagamento(String enderecoPagamento) {
		this.enderecoPagamento = enderecoPagamento;
	}

	public String getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(String dadosBancarios) {
		this.contaBancaria = dadosBancarios;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Beneficio) {
			BeneficiarioConta other = (BeneficiarioConta) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta)
					.append(tipoBeneficiario, other.tipoBeneficiario)
					.append(codPessoa, other.codPessoa).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.append(tipoBeneficiario).append(codPessoa).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).append(tipoBeneficiario)
				.append(codPessoa).build();
	}

	public String getDescricaoParentesco() {
		return parentesco != null ? parentesco.getDescricao() : null;
	}
}
