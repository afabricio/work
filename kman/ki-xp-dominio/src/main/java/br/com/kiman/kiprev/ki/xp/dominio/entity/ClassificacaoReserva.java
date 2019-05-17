package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ClassificacaoReservaPK;

@Entity
@IdClass(ClassificacaoReservaPK.class)
@Table(name = "FO_CLASSIFICACAO_RESERVAS", schema = "KIPREV")
public class ClassificacaoReserva {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;

	@Id
	@Column(name = "COD_CLASSIFICACAO")
	private String codClassificacao;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodClassificacao() {
		return codClassificacao;
	}

	public void setCodClassificacao(String codClassificacao) {
		this.codClassificacao = codClassificacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClassificacaoReserva) {
			ClassificacaoReserva other = (ClassificacaoReserva) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codClassificacao, other.codClassificacao).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codClassificacao)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(codEmpresa).append(codClassificacao).build();
	}

}
