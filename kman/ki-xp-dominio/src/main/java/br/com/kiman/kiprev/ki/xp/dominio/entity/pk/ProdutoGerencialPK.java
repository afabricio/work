package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProdutoGerencialPK implements Serializable {

	private static final long serialVersionUID = -5469380332265383550L;
	private String codEmpresa;
	private String codProdutoGerencial;

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

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
