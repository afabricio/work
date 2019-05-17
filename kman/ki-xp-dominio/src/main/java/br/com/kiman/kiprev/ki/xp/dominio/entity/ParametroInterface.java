package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ParametroPK;

@IdClass(ParametroPK.class)
@Entity
@Table(schema = "KPVCUST11", name = "KI_PARAMETROS_X_INTERF")
@NamedQueries(value = {
		@NamedQuery(name = "findParametroById", query = " SELECT p FROM ParametroInterface p WHERE p.numeroInterface = :pNumeroInterface AND p.codGrupo = :pGrupo  AND p.codParametro = :pCodParametro"),
		@NamedQuery(name = ParametroInterface.BUSCA_POR_NUM_INTERFACE, query = " SELECT p FROM ParametroInterface p WHERE p.numeroInterface = :pNumeroInterface ") })
public class ParametroInterface implements Serializable {

	private static final long serialVersionUID = -3004390534456593778L;

	public static final String BUSCA_POR_NUM_INTERFACE = "ParametroInterface.buscaPorNumInterface";

	@Id
	@Column(name = "NUM_INTERF")
	private Integer numeroInterface;

	@Id
	@Column(name = "COD_PARAM")
	private String codParametro;

	@Id
	@Column(name = "COD_GRUPO")
	private String codGrupo;

	@Column(name = "DESC_PARAM")
	private String descricao;

	@Column(name = "VALOR_PARAM")
	private String valor;

	@Column(name = "OBSERVACOES")
	private String observacoes;

	public ParametroInterface() {
	}

	public ParametroInterface(Integer numeroInterface, String codigoParametro,
			String codigoGrupo, String descricao, String valor,
			String observacoes) {
		this.numeroInterface = numeroInterface;
		this.codParametro = codigoParametro;
		this.codGrupo = codigoGrupo;
		this.descricao = descricao;
		this.valor = valor;
		this.observacoes = observacoes;
	}

	public Integer getNumeroInterface() {
		return numeroInterface;
	}

	public void setNumeroInterface(Integer numerointerface) {
		this.numeroInterface = numerointerface;
	}

	public String getCodParametro() {
		return codParametro;
	}

	public void setCodParametro(String codigoParametro) {
		this.codParametro = codigoParametro;
	}

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codigoGrupo) {
		this.codGrupo = codigoGrupo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ParametroInterface) {
			ParametroInterface other = (ParametroInterface) obj;
			return new EqualsBuilder()
					.append(numeroInterface, other.numeroInterface)
					.append(codParametro, other.codParametro)
					.append(codGrupo, other.codGrupo).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(numeroInterface)
				.append(codParametro).append(codGrupo).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(numeroInterface).append(codParametro).append(codGrupo)
				.build();
	}

}
