package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.dao.JPQLs;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.SolicitacaoPortabilidadePK;

@Entity
@IdClass(SolicitacaoPortabilidadePK.class)
@Table(name = "AF_PORTAB_SOLICITACAO", schema = "KIPREV")
@NamedQuery(name = JPQLs.N_SOLICITACAO_PORTABILIDADE, query = JPQLs.Q_SOLICITACAO_PORTABILIDADE)
public class SolicitacaoPortabilidade {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Id
	@Column(name = "SEQ_PORTABILIDADE")
	private Long seqPortabilidade;
	@Column(name = "NUM_PORTABILIDADE")
	private String numPortabilidade;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getNumFormulario() {
		return numFormulario;
	}

	public void setNumFormulario(Long numFormulario) {
		this.numFormulario = numFormulario;
	}

	public Long getSeqPortabilidade() {
		return seqPortabilidade;
	}

	public void setSeqPortabilidade(Long seqPortabilidade) {
		this.seqPortabilidade = seqPortabilidade;
	}

	public String getNumPortabilidade() {
		return numPortabilidade;
	}

	public void setNumPortabilidade(String numPortabilidade) {
		this.numPortabilidade = numPortabilidade;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario).append(seqPortabilidade).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SolicitacaoPortabilidade) {
			SolicitacaoPortabilidade other = (SolicitacaoPortabilidade) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa).append(numFormulario, other.numFormulario)
					.append(seqPortabilidade, other.seqPortabilidade).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.SHORT_PREFIX_STYLE).append("codEmpresa", codEmpresa)
				.append("numFormulario", numFormulario).append("seqPortabilidade", seqPortabilidade).build();
	}

}
