package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;

public class TransferenciaPK implements Serializable {

	private static final long serialVersionUID = 3886032288937848560L;
	private String codEmpresa;
	private Long numTransferencia;

	public TransferenciaPK() {
		this.codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	}

	public TransferenciaPK(Long numTransferencia) {
		this();
		this.numTransferencia = numTransferencia;
	}

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
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
