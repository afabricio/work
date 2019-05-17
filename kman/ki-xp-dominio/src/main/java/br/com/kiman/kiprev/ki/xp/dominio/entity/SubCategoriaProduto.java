package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.SubCategoriaProdutoPK;

@IdClass(SubCategoriaProdutoPK.class)
@Entity
@Table(schema = "KIPREV", name = "SUBCAT_PRODUCTOS")
public class SubCategoriaProduto {

	@Id
	@Column(name = "COD_CAT_PRODUCTO")
	private String codCategoriaProduto;
	@Id
	@Column(name = "COD_SUBCAT_PRODUCTO")
	private String codSubCategoriaProduto;
	@Column(name = "DESCRIPCION")
	private String descricao;

	public String getCodCategoriaProduto() {
		return codCategoriaProduto;
	}

	public void setCodCategoriaProduto(String codCategoriaProduto) {
		this.codCategoriaProduto = codCategoriaProduto;
	}

	public String getCodSubCategoriaProduto() {
		return codSubCategoriaProduto;
	}

	public void setCodSubCategoriaProduto(String codSubCategoriaProduto) {
		this.codSubCategoriaProduto = codSubCategoriaProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SubCategoriaProduto) {
			SubCategoriaProduto other = (SubCategoriaProduto) obj;
			return new EqualsBuilder()
					.append(codCategoriaProduto, other.codCategoriaProduto)
					.append(codSubCategoriaProduto,
							other.codSubCategoriaProduto).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codCategoriaProduto)
				.append(codSubCategoriaProduto).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(codCategoriaProduto).append(
				codSubCategoriaProduto).build();
	}
}
