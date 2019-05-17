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

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoDocumento;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.DocumentoPK;

@Entity
@Table(name = "ID_PERSONAS", schema = "KIPREV")
@IdClass(DocumentoPK.class)
public class Documento {

	@Id
	@Column(name = "COD_PERSONA")
	private String codPessoa;
	@Id
	@Column(name = "COD_TIPO_ID")
	private String codTipoDocumento;
	@Id
	@Column(name = "NUM_ID")
	private String numDocumento;
//	@Column(name = "FEC_VENCIMIENTO")
//	private LocalDate dataVencimento;
//	@Column(name = "FEC_EMISION")
//	private LocalDate dataEmissao;
	@Column(name = "LOCAL_EXPEDICAO")
	private String localExpedicao;
	@Column(name = "ORGAO_EXPEDIDOR")
	private String orgaoExpedidor;
	@Column(name = "PARENTESCO")
	private String codParentesco;
	@Column(name = "MG_REMESSA_LINHA")
	private String mgRemessaLinha;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PESSOA_TITULAR", referencedColumnName = "COD_PERSONA")
	private Pessoa pessoaTitular;

	public String getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCodTipoDocumento() {
		return codTipoDocumento;
	}

	public void setCodTipoDocumento(String codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String codDocumento) {
		this.numDocumento = codDocumento;
	}

//	public LocalDate getDataVencimento() {
//		return dataVencimento;
//	}
//
//	public void setDataVencimento(LocalDate dataVencimento) {
//		this.dataVencimento = dataVencimento;
//	}
//
//	public LocalDate getDataEmissao() {
//		return dataEmissao;
//	}
//
//	public void setDataEmissao(LocalDate dataEmissao) {
//		this.dataEmissao = dataEmissao;
//	}

	public String getLocalExpedicao() {
		return localExpedicao;
	}

	public void setLocalExpedicao(String localExpedicao) {
		this.localExpedicao = localExpedicao;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public void setCodParentesco(String codParentesco) {
		this.codParentesco = codParentesco;
	}

	public String getMgRemessaLinha() {
		return mgRemessaLinha;
	}

	public void setMgRemessaLinha(String mgRemessaLinha) {
		this.mgRemessaLinha = mgRemessaLinha;
	}

	public Pessoa getPessoaTitular() {
		return pessoaTitular;
	}

	public void setPessoaTitular(Pessoa pessoaTitular) {
		this.pessoaTitular = pessoaTitular;
	}

	public String getCodParentesco() {
		return codParentesco;
	}

	public boolean isCPF() {
		return TipoDocumento.CPF.getValor().equals(codTipoDocumento);
	}

	public boolean isCNPJ() {
		return TipoDocumento.CNPJ.getValor().equals(codTipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			Documento doc = (Documento) obj;
			return new EqualsBuilder().append(codPessoa, doc.codPessoa)
					.append(codTipoDocumento, doc.codTipoDocumento)
					.append(numDocumento, doc.numDocumento).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codPessoa).append(codTipoDocumento)
				.append(numDocumento).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codPessoa).append(codTipoDocumento)
				.append(numDocumento).build();
	}

}
