package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaCorretorPK;

@Entity
@Table(name = "FO_CUENTAS_X_OFICIALES", schema = "KIPREV")
@IdClass(ContaCorretorPK.class)
public class ContaCorretor {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_OFICIAL")
	private String codCorretor;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Column(name = "PCT_PARTICIPACAO")
	private Double pctParticipacao;
	@Column(name = "PRINCIPAL")
	private Boolean indPrincipal;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodCorretor() {
		return codCorretor;
	}

	public void setCodCorretor(String codCorretor) {
		this.codCorretor = codCorretor;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	public Double getPctParticipacao() {
		return pctParticipacao;
	}

	public void setPctParticipacao(Double pctParticipacao) {
		this.pctParticipacao = pctParticipacao;
	}

	public Boolean getIndPrincipal() {
		return Optional.ofNullable(indPrincipal).orElse(false);
	}

	public void setIndPrincipal(Boolean indPrincipal) {
		this.indPrincipal = indPrincipal;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaCorretor) {
			ContaCorretor other = (ContaCorretor) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codCorretor, other.codCorretor)
					.append(codConta, other.codConta).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codCorretor)
				.append(codConta).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).build();
	}

}
