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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaAtualizacaoPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_ATUALIZACAO database table.
 * 
 */
@Entity
@Table(schema="KPVCUST11", name="INT_033_FOLHETERIA_ATUALIZACAO")
@NamedQuery(name="FolheteriaAtualizacao.findAll", query="SELECT f FROM FolheteriaAtualizacao f")
public class FolheteriaAtualizacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaAtualizacaoPK id;

	@Column(name="COD_ATUALIZACAO")
	private Integer codAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ATUALIZACAO")
	private Date dataAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Column(name="ID_ATUALIZACAO")
	private BigDecimal idAtualizacao;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	//bi-directional many-to-one association to FolheteriaDeta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA")
		})
	private FolheteriaDeta folheteriaDeta;

	public FolheteriaAtualizacao() {
	}

	public FolheteriaAtualizacaoPK getId() {
		return this.id;
	}

	public void setId(FolheteriaAtualizacaoPK id) {
		this.id = id;
	}

	public Integer getCodAtualizacao() {
		return this.codAtualizacao;
	}

	public void setCodAtualizacao(Integer codAtualizacao) {
		this.codAtualizacao = codAtualizacao;
	}

	public Date getDataAtualizacao() {
		return this.dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
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

	public BigDecimal getIdAtualizacao() {
		return this.idAtualizacao;
	}

	public void setIdAtualizacao(BigDecimal idAtualizacao) {
		this.idAtualizacao = idAtualizacao;
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

	public FolheteriaDeta getFolheteriaDeta() {
		return this.folheteriaDeta;
	}

	public void setFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		this.folheteriaDeta = folheteriaDeta;
	}

}