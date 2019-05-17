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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PortabilidadePK;

@Entity
@IdClass(PortabilidadePK.class)
@Table(name = "FO_PORTAB_SOLICITACAO", schema = "KIPREV")
public class Portabilidade {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "NUM_PORTABILIDADE")
	private String numPortabilidade;
	@Column(name = "COD_CUENTA")
	private String codConta;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getNumPortabilidade() {
		return numPortabilidade;
	}

	public void setNumPortabilidade(String numPortabilidade) {
		this.numPortabilidade = numPortabilidade;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numPortabilidade).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Portabilidade) {
			Portabilidade other = (Portabilidade) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(numPortabilidade, other.numPortabilidade).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.SHORT_PREFIX_STYLE).append("codEmpresa", codEmpresa)
				.append("numPortabilidade", numPortabilidade).build();
	}

}
