package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.Serializable;
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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaContribFunPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_CONTRIB_FUN database table.
 * 
 */
@Entity
@Table(schema = "KPVCUST11", name="INT_033_FOLHETERIA_CONTRIB_FUN")
@NamedQuery(name="FolheteriaContribFun.findAll", query="SELECT i FROM FolheteriaContribFun i")
public class FolheteriaContribFun implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaContribFunPK id;

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

	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;

	//bi-directional many-to-one association to FolheteriaTransFinan
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA"),
		@JoinColumn(name="ID_TF_DETA", referencedColumnName="ID_TF_DETA")
		})
	private FolheteriaTransFinan folheteriaTransFinan;

	public FolheteriaContribFun() {
	}

	public FolheteriaContribFunPK getId() {
		return this.id;
	}

	public void setId(FolheteriaContribFunPK id) {
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

	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public FolheteriaTransFinan getFolheteriaTransFinan() {
		return this.folheteriaTransFinan;
	}

	public void setFolheteriaTransFinan(FolheteriaTransFinan folheteriaTransFinan) {
		this.folheteriaTransFinan = folheteriaTransFinan;
	}

}