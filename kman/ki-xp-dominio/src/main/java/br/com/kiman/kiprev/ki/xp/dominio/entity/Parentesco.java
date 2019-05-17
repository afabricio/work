package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "PARENTEZCOS", schema = "KIPREV")
public class Parentesco {

	@Id
	@Column(name = "PARENTEZCO")
	private Long codParentesco;

	@Column(name = "DESCRIPCION")
	private String descricao;

	public Long getCodParentesco() {
		return codParentesco;
	}

	public void setCodParentesco(Long codParentesco) {
		this.codParentesco = codParentesco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Parentesco) {
			Parentesco other = (Parentesco) obj;
			return new EqualsBuilder().append(codParentesco,
					other.codParentesco).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codParentesco).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE).append(
				codParentesco).build();
	}

}
