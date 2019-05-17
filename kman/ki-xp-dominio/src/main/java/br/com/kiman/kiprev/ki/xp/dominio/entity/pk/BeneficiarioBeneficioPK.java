package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BeneficiarioBeneficioPK implements Serializable {

	private static final long serialVersionUID = 2481569143627901377L;
	private String codEmpresa;
	private String codConta;
	private String tipoBeneficiario;
	private String codPessoa;
	private Long codPlano;
	private Long codBeneficio;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	public String getTipoBeneficiario() {
		return tipoBeneficiario;
	}

	public void setTipoBeneficiario(String tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public Long getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(Long codPlano) {
		this.codPlano = codPlano;
	}

	public Long getCodBeneficio() {
		return codBeneficio;
	}

	public void setCodBeneficio(Long codBeneficio) {
		this.codBeneficio = codBeneficio;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
