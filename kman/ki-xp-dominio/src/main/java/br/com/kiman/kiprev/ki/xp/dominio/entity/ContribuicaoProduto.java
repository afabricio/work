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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContribuicaoProdutoPK;

@Entity
@IdClass(ContribuicaoProdutoPK.class)
@Table(schema = "KIPREV", name = "FO_CONTRIB_X_PRODUTO")
public class ContribuicaoProduto {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_PRODUTO")
	private String codProduto;
	@Id
	@Column(name = "COD_CONTRIB")
	private String codContribuicao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TIPSALDO", referencedColumnName = "COD_TIPSALDO", insertable = false, updatable = false) })
	private Reserva reserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false) })
	private Beneficio beneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTRIB", referencedColumnName = "COD_CONTRIB", insertable = false, updatable = false) })
	private Contribuicao contribuicao;

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

	public String getCodContribuicao() {
		return codContribuicao;
	}

	public void setCodContribuicao(String codContribuicao) {
		this.codContribuicao = codContribuicao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public boolean isRegular() {
		return contribuicao != null && contribuicao.isRegular();
	}

	public boolean isSobrevivencia() {
		return beneficio != null && beneficio.isSobrevivencia();
	}

	public boolean isInicial() {
		return contribuicao != null && contribuicao.isInicial();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContribuicaoProduto) {
			ContribuicaoProduto other = (ContribuicaoProduto) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codProduto, other.codProduto)
					.append(codContribuicao, other.codContribuicao).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codProduto)
				.append(codContribuicao).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codProduto).append(codContribuicao)
				.build();
	}

}
