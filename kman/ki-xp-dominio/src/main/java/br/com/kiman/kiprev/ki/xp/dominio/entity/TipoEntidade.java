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
@Table(name = "TIPOS_ENTES", schema = "KIPREV")
public class TipoEntidade {

	@Id
	@Column(name = "TIPO_ENTE")
	private String tipo;

	@Column(name = "DESCRIPCION")
	private String descricao;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tipo).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EntidadeExterna) {
			TipoEntidade other = (TipoEntidade) obj;
			return new EqualsBuilder().append(tipo, other.tipo).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE).append(tipo)
				.build();
	}

}
