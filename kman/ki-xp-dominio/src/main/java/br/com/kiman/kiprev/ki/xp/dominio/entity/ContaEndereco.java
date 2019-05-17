package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaEnderecoPK;

@Entity
@Table(name = "FO_DIR_CONTA", schema = "KIPREV")
@IdClass(ContaEnderecoPK.class)
public class ContaEndereco {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Id
	@Column(name = "COD_CLIENTE")
	private String codCliente;
	@Id
	@Column(name = "COD_DIRECCION")
	private String codEndereco;
	@Column(name = "DSC_DIRECCION")
	private String descricao;
	@Column(name = "TIP_DIRECCION")
	private String tipoEndereco;
	@Column(name = "COD_CLASSE")
	private String codClasse;
	@Column(name = "CORRESPONDENCIA")
	private Boolean indCorrespondencia;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_DIRECCION", referencedColumnName = "COD_ENDERECO", insertable = false, updatable = false)
	private Endereco endereco;

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

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(String codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getCodClasse() {
		return codClasse;
	}

	public void setCodClasse(String codClasse) {
		this.codClasse = codClasse;
	}

	public Boolean getIndCorrespondencia() {
		return indCorrespondencia;
	}

	public void setIndCorrespondencia(Boolean indCorrespondencia) {
		this.indCorrespondencia = indCorrespondencia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaEndereco) {
			ContaEndereco other = (ContaEndereco) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta)
					.append(codCliente, other.codCliente)
					.append(codEndereco, other.codEndereco).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.append(codCliente).append(codEndereco).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).append(codCliente)
				.append(codEndereco).build();
	}

}
