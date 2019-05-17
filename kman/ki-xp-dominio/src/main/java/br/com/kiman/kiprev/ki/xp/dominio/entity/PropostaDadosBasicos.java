package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoSexoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PropostaPK;

@Entity
@IdClass(PropostaPK.class)
@Table(name = "AF_DATOS_BASICOS", schema = "KIPREV")
public class PropostaDadosBasicos {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Column(name = "SEXO")
	private TipoSexoEnum tipoSexo;
	@Column(name = "FEC_NACIMIENTO")
	private LocalDate dataNascimento;
	@Column(name = "PRIMER_NOMBRE")
	private String nome;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Set<PropostaDocumento> documentosProposta = Sets.newHashSet();

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

	public TipoSexoEnum getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(TipoSexoEnum tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<PropostaDocumento> getDocumentosProposta() {
		return documentosProposta;
	}

	public void setDocumentosProposta(Set<PropostaDocumento> documentosProposta) {
		this.documentosProposta = documentosProposta;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropostaDadosBasicos) {
			PropostaDadosBasicos other = (PropostaDadosBasicos) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(numFormulario, other.numFormulario).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(codEmpresa).append(numFormulario).build();
	}

}
