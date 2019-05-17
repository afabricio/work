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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ProdutoGerencialPK;

@IdClass(ProdutoGerencialPK.class)
@Entity
@Table(schema = "KIPREV", name = "FO_PRODUTO_GERENCIAL")
public class ProdutoGerencial {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_PRODUTO_GER")
	private String codProdutoGerencial;
	@Column(name = "DESC_PRODUTO_GER")
	private String descricao;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodProdutoGerencial() {
		return codProdutoGerencial;
	}

	public void setCodProdutoGerencial(String codProdutoGerencial) {
		this.codProdutoGerencial = codProdutoGerencial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProdutoGerencial) {
			ProdutoGerencial p = (ProdutoGerencial) obj;
			return new EqualsBuilder().append(codEmpresa, p.codEmpresa)
					.append(codProdutoGerencial, p.codProdutoGerencial)
					.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa)
				.append(codProdutoGerencial).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(codEmpresa).append(codProdutoGerencial).build();
	}

}
