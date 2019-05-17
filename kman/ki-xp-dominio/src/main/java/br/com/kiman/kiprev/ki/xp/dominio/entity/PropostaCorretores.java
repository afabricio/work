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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PropostaCorretoresPK;

@Entity
@IdClass(PropostaCorretoresPK.class)
@Table(name = "AF_SOLICITUD_X_OFICIALES", schema = "KIPREV")
public class PropostaCorretores {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Id
	@Column(name = "COD_OFICIAL")
	private String codOficial;
	@Column(name = "PRINCIPAL")
	private Boolean indPrincipal = false;
	@Column(name = "PCT_PARTICIPACAO")
	private Double percentual;

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

	public String getCodOficial() {
		return codOficial;
	}

	public void setCodOficial(String codOficial) {
		this.codOficial = codOficial;
	}

	public Boolean getIndPrincipal() {
		return indPrincipal;
	}

	public void setIndPrincipal(Boolean indPrincipal) {
		this.indPrincipal = indPrincipal;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario)
				.append(codOficial).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropostaCorretores) {
			PropostaCorretores other = (PropostaCorretores) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(numFormulario, other.numFormulario)
					.append(codOficial, other.codOficial).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(numFormulario).append(codOficial)
				.build();
	}

}
