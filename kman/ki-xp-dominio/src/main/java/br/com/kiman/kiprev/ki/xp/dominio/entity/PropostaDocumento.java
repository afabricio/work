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

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.DocumentoPropostaPK;

@Entity
@IdClass(DocumentoPropostaPK.class)
@Table(name = "AF_ID_X_SOLIC", schema = "KIPREV")
public class PropostaDocumento {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Id
	@Column(name = "COD_TIPO_ID")
	private String codDocumento;
	@Id
	@Column(name = "NUM_ID")
	private String numDocumento;

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

	public String getCodDocumento() {
		return codDocumento;
	}

	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropostaDocumento) {
			PropostaDocumento other = (PropostaDocumento) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(numFormulario, other.numFormulario)
					.append(codDocumento, other.codDocumento)
					.append(numDocumento, other.numDocumento).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario)
				.append(codDocumento).append(numDocumento).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(numFormulario).append(codDocumento)
				.append(numDocumento).build();
	}

}
