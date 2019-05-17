package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ContaContribuicaoPK implements Serializable {

	private static final long serialVersionUID = -1107637202095284943L;
	private String codEmpresa;
	private String codCertificado;
	private String codContribuicao;
	private String primeiroAporte;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodCertificado() {
		return codCertificado;
	}

	public void setCodCertificado(String codCertificado) {
		this.codCertificado = codCertificado;
	}

	public String getCodContribuicao() {
		return codContribuicao;
	}

	public void setCodContribuicao(String codContribuicao) {
		this.codContribuicao = codContribuicao;
	}

	public String getPrimeiroAporte() {
		return primeiroAporte;
	}

	public void setPrimeiroAporte(String primeiroAporte) {
		this.primeiroAporte = primeiroAporte;
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
