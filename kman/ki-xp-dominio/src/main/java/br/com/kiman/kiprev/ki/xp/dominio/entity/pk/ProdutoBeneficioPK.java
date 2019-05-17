package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProdutoBeneficioPK implements Serializable {

	private static final long serialVersionUID = -2258941083207919278L;
	private String codEmpresa;
	private String codProduto;
	private Long codBeneficio;
	private Long codPlano;

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

	public Long getCodBeneficio() {
		return codBeneficio;
	}

	public void setCodBeneficio(Long codBeneficio) {
		this.codBeneficio = codBeneficio;
	}

	public Long getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(Long codPlano) {
		this.codPlano = codPlano;
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
