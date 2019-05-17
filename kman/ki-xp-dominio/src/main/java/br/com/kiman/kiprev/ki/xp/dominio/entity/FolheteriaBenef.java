package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaBenefPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_BENEF database table.
 * 
 */
@Entity
@Table(schema="KPVCUST11", name="INT_033_FOLHETERIA_BENEF")
@NamedQuery(name="FolheteriaBenef.findAll", query="SELECT f FROM FolheteriaBenef f")
public class FolheteriaBenef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaBenefPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Column(name="GRAU_PARENTESCO")
	private Integer grauParentesco;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	@Column(name="NOME_BENEFICIARIO")
	private String nomeBeneficiario;

	@Column(name="PERCENT_PARTICIPACAO")
	private BigDecimal percentParticipacao;

	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;

	//bi-directional many-to-one association to FolheteriaDeta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA")
		})
	private FolheteriaDeta folheteriaDeta;

	public FolheteriaBenef() {
	}

	public FolheteriaBenefPK getId() {
		return this.id;
	}

	public void setId(FolheteriaBenefPK id) {
		this.id = id;
	}

	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataModificacao() {
		return this.dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public Integer getGrauParentesco() {
		return this.grauParentesco;
	}

	public void setGrauParentesco(Integer grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getIncluidoPor() {
		return this.incluidoPor;
	}

	public void setIncluidoPor(String incluidoPor) {
		this.incluidoPor = incluidoPor;
	}

	public String getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getNomeBeneficiario() {
		return this.nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public BigDecimal getPercentParticipacao() {
		return this.percentParticipacao;
	}

	public void setPercentParticipacao(BigDecimal percentParticipacao) {
		this.percentParticipacao = percentParticipacao;
	}

	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public FolheteriaDeta getFolheteriaDeta() {
		return this.folheteriaDeta;
	}

	public void setFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		this.folheteriaDeta = folheteriaDeta;
	}

}