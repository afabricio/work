package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoEstadoCivilEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoSexoEnum;

@Entity
@Table(name = "PERSONAS_FISICAS", schema = "KIPREV")
public class PessoaFisica {

	@Id
	@Column(name = "COD_PER_FISICA")
	private String codPessoaFisica;
	@Column(name = "EST_CIVIL")
	private TipoEstadoCivilEnum tipoEstadoCivil;
	@Column(name = "SEXO")
	private TipoSexoEnum tipoSexo;
	@Column(name = "FEC_NACIMIENTO")
	private LocalDate dataNascimento;
	@Column(name = "PRIMER_NOMBRE")
	private String nomePessoaFisica;
	@Column(name = "PROFESION")
	private String codProfissao;
	@Column(name = "ES_MAL_DEUDOR")
	private Boolean indDevedor;
	@Column(name = "NACIONALIDAD")
	private String nacionalidade;
	@Column(name = "COD_SECTOR")
	private String codAtividadeEconomica;
	@Column(name = "NUM_HIJOS")
	private Long numFilhos;
	@Column(name = "NUM_DEPENDIENTES")
	private Long numDependentes;
	@Column(name = "ES_RESIDENTE")
	private Boolean indResidente;
	@Column(name = "TIEMPO_VIVIEN_ACT")
	private Long tempoResidencia;
	@Column(name = "TOTAL_INGRESOS")
	private Double rendimentoBruto;
	@Column(name = "PATRIMONIO_ESTIMADO")
	private Double patrimonioEstimado;
	@Column(name = "COD_PAIS")
	private String codPais;
	@Column(name = "ACTIVIDAD")
	private String atividadeAtual;
	@Column(name = "COD_NACIONALIDAD")
	private String codNacionalidade;
	@Column(name = "MG_REMESSA_LINHA")
	private String mgRemessaLinha;
	@Column(name = "COD_PAIS_RESIDENCIA")
	private String codPaisResidencia;
	@Column(name = "NIF")
	private String NIF;
	@Column(name = "DISPENSA_NIF")
	private Boolean indDispensaNIF;
	
	public String getCodPessoaFisica() {
		return codPessoaFisica;
	}

	public void setCodPessoaFisica(String codPessoaFisica) {
		this.codPessoaFisica = codPessoaFisica;
	}

	public TipoEstadoCivilEnum getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}

	public void setTipoEstadoCivil(TipoEstadoCivilEnum tipoEstadoCivil) {
		this.tipoEstadoCivil = tipoEstadoCivil;
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

	public String getNomePessoaFisica() {
		return nomePessoaFisica;
	}

	public void setNomePessoaFisica(String nomePessoaFisica) {
		this.nomePessoaFisica = nomePessoaFisica;
	}

	public String getCodProfissao() {
		return codProfissao;
	}

	public void setCodProfissao(String codProfissao) {
		this.codProfissao = codProfissao;
	}

	public Boolean getIndDevedor() {
		return indDevedor;
	}

	public void setIndDevedor(Boolean indDevedor) {
		this.indDevedor = indDevedor;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCodAtividadeEconomica() {
		return codAtividadeEconomica;
	}

	public void setCodAtividadeEconomica(String codAtividadeEconomica) {
		this.codAtividadeEconomica = codAtividadeEconomica;
	}

	public Long getNumFilhos() {
		return numFilhos;
	}

	public void setNumFilhos(Long numFilhos) {
		this.numFilhos = numFilhos;
	}

	public Long getNumDependentes() {
		return numDependentes;
	}

	public void setNumDependentes(Long numDependentes) {
		this.numDependentes = numDependentes;
	}

	public Boolean getIndResidente() {
		return indResidente;
	}

	public void setIndResidente(Boolean indResidente) {
		this.indResidente = indResidente;
	}

	public Long getTempoResidencia() {
		return tempoResidencia;
	}

	public void setTempoResidencia(Long tempoResidencia) {
		this.tempoResidencia = tempoResidencia;
	}

	public Double getRendimentoBruto() {
		return rendimentoBruto;
	}

	public void setRendimentoBruto(Double rendimentoBruto) {
		this.rendimentoBruto = rendimentoBruto;
	}

	public Double getPatrimonioEstimado() {
		return patrimonioEstimado;
	}

	public void setPatrimonioEstimado(Double patrimonioEstimado) {
		this.patrimonioEstimado = patrimonioEstimado;
	}

	public String getCodPais() {
		return codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getAtividadeAtual() {
		return atividadeAtual;
	}

	public void setAtividadeAtual(String atividadeAtual) {
		this.atividadeAtual = atividadeAtual;
	}

	public String getCodNacionalidade() {
		return codNacionalidade;
	}

	public void setCodNacionalidade(String codNacionalidade) {
		this.codNacionalidade = codNacionalidade;
	}

	public String getMgRemessaLinha() {
		return mgRemessaLinha;
	}

	public void setMgRemessaLinha(String mgRemessaLinha) {
		this.mgRemessaLinha = mgRemessaLinha;
	}

	public String getCodPaisResidencia() {
		return codPaisResidencia;
	}

	public void setCodPaisResidencia(String codPaisResidencia) {
		this.codPaisResidencia = codPaisResidencia;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public Boolean getIndDispensaNIF() {
		return indDispensaNIF;
	}

	public void setIndDispensaNIF(Boolean indDispensaNIF) {
		this.indDispensaNIF = indDispensaNIF;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PessoaFisica) {
			PessoaFisica pessoa = (PessoaFisica) obj;
			return new EqualsBuilder().append(getCodPessoaFisica(),
					pessoa.getCodPessoaFisica()).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getCodPessoaFisica()).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE).append(
				getCodPessoaFisica()).build();
	}

}
