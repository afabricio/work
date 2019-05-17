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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.CanalPagamentoPessoaPK;

@Entity
@IdClass(CanalPagamentoPessoaPK.class)
@Table(schema = "KIPREV", name = "RE_CANAIS_X_PESSOA")
//@NamedQueries(value = {@NamedQuery(name  = JPQLs.N_BUSCA_CANAL_PESSOA_POR_ID, query = JPQLs.Q_BUSCA_CANAL_PESSOA_POR_ID)})
public class CanalPagamentoPessoa {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CANAL")
	private String codCanal;
	@Id
	@Column(name = "COD_PESSOA")
	private String codPessoa;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "TIP_CANAL")
	private String tipoCanal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "TIP_CANAL", referencedColumnName = "TIP_CANAL", insertable = false, updatable = false) })
	private CanalPagamento canalPagamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_ENDERECO", referencedColumnName = "COD_DIRECCION", insertable = false, updatable = false) })
	private EnderecoPessoa enderecoPessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PESSOA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTA_BAN", referencedColumnName = "COD_CONTABAN", insertable = false, updatable = false) })
	private ContaBancariaPessoa contaBancariaPessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTipoCanal() {
		return tipoCanal;
	}

	public void setTipoCanal(String tipoCanal) {
		this.tipoCanal = tipoCanal;
	}

	public ContaBancariaPessoa getContaBancariaPessoa() {
		return contaBancariaPessoa;
	}

	public void setContaBancariaPessoa(ContaBancariaPessoa contaBancariaPessoa) {
		this.contaBancariaPessoa = contaBancariaPessoa;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodCanal() {
		return codCanal;
	}

	public void setCodCanal(String codCanal) {
		this.codCanal = codCanal;
	}

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CanalPagamento getCanalPagamento() {
		return canalPagamento;
	}

	public void setCanalPagamento(CanalPagamento canalPagamento) {
		this.canalPagamento = canalPagamento;
	}

	public boolean isFichaOuCarne() {
		return canalPagamento != null && canalPagamento.isFichaOuCarne();
	}

	public boolean isDebito() {
		return canalPagamento != null && canalPagamento.isDebito();
	}

	public EnderecoPessoa getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(EnderecoPessoa enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CanalPagamentoPessoa) {
			CanalPagamentoPessoa other = (CanalPagamentoPessoa) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codCanal, other.codCanal)
					.append(codPessoa, other.codPessoa).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codCanal)
				.append(codPessoa).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codCanal).append(codPessoa).build();
	}

}
