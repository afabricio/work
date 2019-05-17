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

import br.com.kiman.kiprev.ki.xp.dominio.constants.FormaPagamentoBeneficioEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoPrazoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoReversaoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.TipoPagamentoBeneficioPK;

@Entity
@IdClass(TipoPagamentoBeneficioPK.class)
@Table(name = "BE_TIPPAGOS", schema = "KIPREV")
public class TipoPagamentoBeneficio {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "TIP_PAGO")
	private Long codTipoPagamento;
	@Column(name = "DES_PAGO")
	private String descricao;
	@Column(name = "PLAZO")
	private TipoPrazoEnum tipoPrazo;
	@Column(name = "TIPO_REVERS")
	private TipoReversaoEnum tipoReversao;
	@Column(name = "FORMA_PGTO")
	private FormaPagamentoBeneficioEnum formaPagamento;
	@Column(name = "GARANTE_PRAZOMIN")
	private String prazoMinimo;
	@Column(name = "IND_PGTO_MENOR")
	private Boolean indPagamentoMenor;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getCodTipoPagamento() {
		return codTipoPagamento;
	}

	public void setCodTipoPagamento(Long codTipoPagamento) {
		this.codTipoPagamento = codTipoPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPrazoEnum getTipoPrazo() {
		return tipoPrazo;
	}

	public void setTipoPrazo(TipoPrazoEnum tipoPrazo) {
		this.tipoPrazo = tipoPrazo;
	}

	public TipoReversaoEnum getTipoReversao() {
		return tipoReversao;
	}

	public void setTipoReversao(TipoReversaoEnum tipoReversao) {
		this.tipoReversao = tipoReversao;
	}

	public FormaPagamentoBeneficioEnum getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoBeneficioEnum formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getPrazoMinimo() {
		return prazoMinimo;
	}

	public void setPrazoMinimo(String prazoMinimo) {
		this.prazoMinimo = prazoMinimo;
	}

	public Boolean getIndPagamentoMenor() {
		return indPagamentoMenor;
	}

	public void setIndPagamentoMenor(Boolean indPagamentoMenor) {
		this.indPagamentoMenor = indPagamentoMenor;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa)
				.append(codTipoPagamento).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TipoPagamentoBeneficio) {
			TipoPagamentoBeneficio other = (TipoPagamentoBeneficio) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codTipoPagamento, other.codTipoPagamento).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codTipoPagamento).build();
	}

}
