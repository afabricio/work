package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoMeioPagamento;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.CanalPagamentoPK;

@Entity
@IdClass(CanalPagamentoPK.class)
@Table(schema = "KIPREV", name = "PA_CANAIS")
public class CanalPagamento {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "TIP_CANAL")
	private String tipoCanal;
	@Column(name = "NOME")
	private String descricao;
	@Column(name = "COD_MEIO_PGTO")
	private TipoMeioPagamento codMeioPagamento;
	
	@Column(name = "ANTECEDENCIA_LIMITE")
	private Integer antecedenciaLimite;
	
	
	



	public Integer getAntecedenciaLimite() {
		return antecedenciaLimite;
	}

	public void setAntecedenciaLimite(Integer antecedenciaLimite) {
		this.antecedenciaLimite = antecedenciaLimite;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getTipoCanal() {
		return tipoCanal;
	}

	public void setTipoCanal(String tipoCanal) {
		this.tipoCanal = tipoCanal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoMeioPagamento getCodMeioPagamento() {
		return codMeioPagamento;
	}

	public void setCodMeioPagamento(TipoMeioPagamento codMeioPagamento) {
		this.codMeioPagamento = codMeioPagamento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CanalPagamento) {
			CanalPagamento other = (CanalPagamento) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(tipoCanal, other.tipoCanal).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(tipoCanal)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(tipoCanal).build();
	}

	public boolean isFichaOuCarne() {
		return isFicha() || isCarne();
	}

	public boolean isDebito() {
		return Optional.ofNullable(codMeioPagamento).map(t -> {
			return codMeioPagamento.isDebito();
		}).orElse(false);
	}

	public boolean isFicha() {
		return Optional.ofNullable(codMeioPagamento).map(t -> {
			return codMeioPagamento.isFicha();
		}).orElse(false);
	}

	public boolean isCarne() {
		return Optional.ofNullable(codMeioPagamento).map(t -> {
			return codMeioPagamento.isCarne();
		}).orElse(false);
	}

}
