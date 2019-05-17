package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaPK;

@Entity
@IdClass(ContaPK.class)
@Table(name = "FO_DADOS_COMERCIAL", schema = "KIPREV")
public class DadosComercial {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Column(name = "COD_OFICINA_EMISSAO")
	private String codAgenciaEmissao;

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

	public String getCodAgenciaEmissao() {
		return codAgenciaEmissao;
	}

	public void setCodAgenciaEmissao(String codAgenciaEmissao) {
		this.codAgenciaEmissao = codAgenciaEmissao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DadosComercial) {
			DadosComercial other = (DadosComercial) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(codEmpresa).append(codConta).build();
	}

}
