package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoEmailEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaEmailPK;

@Entity
@Table(name = "FO_EMAIL_CONTA", schema = "KIPREV")
@IdClass(ContaEmailPK.class)
public class ContaEmail {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Id
	@Column(name = "COD_EMAIL")
	private Long codEmail;
	@Column(name = "COD_CLIENTE")
	private String codCliente;
	@Column(name = "TIP_EMAIL")
	private TipoEmailEnum tipoEmail;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "RECEBE_EMAIL")
	private Boolean indRecebeEmail;
	@Column(name = "ENVIA_EMAILBENEF")
	private Boolean indEnviaCorrespondenciaBenef;
	@Transient
	private Boolean indCorrespondencia;

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

	public Long getCodEmail() {
		return codEmail;
	}

	public void setCodEmail(Long codEmail) {
		this.codEmail = codEmail;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public TipoEmailEnum getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(TipoEmailEnum tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIndRecebeEmail() {
		return indRecebeEmail;
	}

	public void setIndRecebeEmail(Boolean indRecebeEmail) {
		this.indRecebeEmail = indRecebeEmail;
	}

	public Boolean getIndEnviaCorrespondenciaBenef() {
		return indEnviaCorrespondenciaBenef;
	}

	public void setIndEnviaCorrespondenciaBenef(
			Boolean indEnviaCorrespondenciaBenef) {
		this.indEnviaCorrespondenciaBenef = indEnviaCorrespondenciaBenef;
	}

	public Boolean getIndCorrespondencia() {
		return indCorrespondencia;
	}

	public void setIndCorrespondencia(Boolean indCorrespondencia) {
		this.indCorrespondencia = indCorrespondencia;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaEmail) {
			ContaEmail other = (ContaEmail) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta)
					.append(codEmail, other.codEmail).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.append(codEmail).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).append(codEmail)
				.build();
	}

}
