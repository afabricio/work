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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.TransferenciaPK;

@Entity
@IdClass(TransferenciaPK.class)
@Table(name = "FO_TRANSF_SOLICITACAO", schema = "KIPREV")
public class Transferencia {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "NUM_TRANSFERENCIA")
	private Long numTransferencia;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getNumTransferencia() {
		return numTransferencia;
	}

	public void setNumTransferencia(Long numTransferencia) {
		this.numTransferencia = numTransferencia;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numTransferencia).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Transferencia) {
			Transferencia other = (Transferencia) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(numTransferencia, other.numTransferencia).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.SHORT_PREFIX_STYLE).append("codEmpresa", codEmpresa)
				.append("numTransferencia", numTransferencia).build();
	}

}
