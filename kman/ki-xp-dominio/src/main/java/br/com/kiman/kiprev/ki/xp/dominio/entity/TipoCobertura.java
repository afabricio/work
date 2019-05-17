package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(schema = "KIPREV", name = "BE_TIPOS_COBERTURA")
public class TipoCobertura {

	@Id
	@Column(name = "COD_TIPCOBERTURA")
	private String codTipoCobertura;
	@Column(name = "DES_TIPCOBERTURA")
	private String descricao;
	@Column(name = "PERMITE_REVERSION")
	private Boolean indPermiteReversao;
	@Column(name = "E_RISCO")
	private Boolean indRisco;

	public String getCodTipoCobertura() {
		return codTipoCobertura;
	}

	public void setCodTipoCobertura(String codTipoCobertura) {
		this.codTipoCobertura = codTipoCobertura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getIndPermiteReversao() {
		return indPermiteReversao;
	}

	public void setIndPermiteReversao(Boolean indPermiteReversao) {
		this.indPermiteReversao = indPermiteReversao;
	}

	public Boolean getIndRisco() {
		return indRisco;
	}

	public void setIndRisco(Boolean indRisco) {
		this.indRisco = indRisco;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE).append(
				codTipoCobertura).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TipoCobertura) {
			TipoCobertura other = (TipoCobertura) obj;
			return new EqualsBuilder().append(codTipoCobertura,
					other.codTipoCobertura).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codTipoCobertura).build();
	}

}
