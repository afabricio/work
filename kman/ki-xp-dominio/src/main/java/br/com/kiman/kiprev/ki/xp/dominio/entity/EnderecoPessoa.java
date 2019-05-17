package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.EnderecoPessoaPK;

@Entity
@Table(name = "DIR_PERSONAS", schema = "KIPREV")
@IdClass(EnderecoPessoaPK.class)
public class EnderecoPessoa {

	@Id
	@Column(name = "COD_PERSONA")
	private String codPessoa;
	@Id
	@Column(name = "COD_DIRECCION")
	private String codEndereco;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_DIRECCION", referencedColumnName = "COD_ENDERECO", insertable = false, updatable = false)
	private Endereco endereco;

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(String codEndereco) {
		this.codEndereco = codEndereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codPessoa).append(codEndereco)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnderecoPessoa) {
			EnderecoPessoa other = (EnderecoPessoa) obj;
			return new EqualsBuilder().append(codPessoa, other.codPessoa)
					.append(codEndereco, other.codEndereco).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("codPessoa", codPessoa)
				.append("codEndereco", codEndereco).build();
	}

	public boolean comparaDadosEndereco(String cep, String logradouro,
			String numero, String bairro) {
		return endereco.comparaEndereco(cep, logradouro, numero, bairro);

	}

}
