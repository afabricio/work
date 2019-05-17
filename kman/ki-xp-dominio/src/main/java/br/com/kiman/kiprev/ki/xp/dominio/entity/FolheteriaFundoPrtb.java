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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaFundoPrtbPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_FUNDO_PRTB database table.
 * 
 */
@Entity
@Table(schema = "KPVCUST11", name="INT_033_FOLHETERIA_FUNDO_PRTB")
@NamedQuery(name="FolheteriaFundoPrtb.findAll", query="SELECT i FROM FolheteriaFundoPrtb i")
public class FolheteriaFundoPrtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaFundoPrtbPK id;

	@Column(name="CNPJ_FUNDO")
	private String cnpjFundo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	@Column(name="NOME_FUNDO")
	private String nomeFundo;

	@Column(name="NUM_PERC_DISTRIBUICAO")
	private BigDecimal numPercDistribuicao;

	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;

	//bi-directional many-to-one association to FolheteriaPortab
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA"),
		@JoinColumn(name="ID_PORTAB_DETA", referencedColumnName="ID_PORTAB_DETA")
		})
	private FolheteriaPortab folheteriaPortab;

	public FolheteriaFundoPrtb() {
	}

	public FolheteriaFundoPrtbPK getId() {
		return this.id;
	}

	public void setId(FolheteriaFundoPrtbPK id) {
		this.id = id;
	}

	public String getCnpjFundo() {
		return this.cnpjFundo;
	}

	public void setCnpjFundo(String cnpjFundo) {
		this.cnpjFundo = cnpjFundo;
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

	public String getNomeFundo() {
		return this.nomeFundo;
	}

	public void setNomeFundo(String nomeFundo) {
		this.nomeFundo = nomeFundo;
	}

	public BigDecimal getNumPercDistribuicao() {
		return this.numPercDistribuicao;
	}

	public void setNumPercDistribuicao(BigDecimal numPercDistribuicao) {
		this.numPercDistribuicao = numPercDistribuicao;
	}

	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public FolheteriaPortab getFolheteriaPortab() {
		return this.folheteriaPortab;
	}

	public void setFolheteriaPortab(FolheteriaPortab folheteriaPortab) {
		this.folheteriaPortab = folheteriaPortab;
	}

}