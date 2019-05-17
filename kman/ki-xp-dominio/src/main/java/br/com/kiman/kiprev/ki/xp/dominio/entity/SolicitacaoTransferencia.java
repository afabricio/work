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
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.SolicitacaoTransferenciaPK;

@Entity
@IdClass(SolicitacaoTransferenciaPK.class)
@Table(name = "AF_TRANSF_SOLIC", schema = "KIPREV")
@NamedQuery(name = JPQLs.N_SOLICITACAO_TRANSFERENCIA, query = JPQLs.Q_SOLICITACAO_TRANSFERENCIA)
public class SolicitacaoTransferencia {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Id
	@Column(name = "SEQ_TRANSF")
	private Long seqTransferencia;

	@Column(name = "NUM_TRANSFERENCIA")
	private Long numTransferencia;

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

	public Long getSeqTransferencia() {
		return seqTransferencia;
	}

	public void setSeqTransferencia(Long seqTransferencia) {
		this.seqTransferencia = seqTransferencia;
	}

	public Long getNumTransferencia() {
		return numTransferencia;
	}

	public void setNumTransferencia(Long numTransferencia) {
		this.numTransferencia = numTransferencia;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario).append(seqTransferencia).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SolicitacaoTransferencia) {
			SolicitacaoTransferencia other = (SolicitacaoTransferencia) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa).append(numFormulario, other.numFormulario)
					.append(seqTransferencia, other.seqTransferencia).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.SHORT_PREFIX_STYLE).append("codEmpresa", codEmpresa)
				.append("numFormulario", numFormulario).append("seqTransferencia", seqTransferencia).build();
	}

}
