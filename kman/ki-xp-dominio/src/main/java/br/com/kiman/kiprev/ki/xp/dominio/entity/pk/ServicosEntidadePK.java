package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ServicosEntidadePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3701344857900083974L;
	private String codEntidade;
	private String codServico;
	
	
	public String getCodEntidade() {
		return codEntidade;
	}
	public void setCodEntidade(String codEntidade) {
		this.codEntidade = codEntidade;
	}
	public String getCodServico() {
		return codServico;
	}
	public void setCodServico(String codServico) {
		this.codServico = codServico;
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
