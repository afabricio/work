package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SubCategoriaProdutoPK implements Serializable {

	private static final long serialVersionUID = -3117607683198725741L;
	private String codCategoriaProduto;
	private String codSubCategoriaProduto;

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

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}
