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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaAnexoPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_ANEXOS database table.
 * 
 */
@Entity
@Table(schema="KPVCUST11", name="INT_033_FOLHETERIA_ANEXOS")
@NamedQuery(name="FolheteriaAnexo.findAll", query="SELECT f FROM FolheteriaAnexo f")
public class FolheteriaAnexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaAnexoPK id;

	private String anexo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Column(name="ID_ANEXO")
	private String idAnexo;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	@Column(name="NOME_ANEXO")
	private String nomeAnexo;

	@Column(name="TIPO_DOC_ANEXADO")
	private Integer tipoDocAnexado;

	//bi-directional many-to-one association to FolheteriaDeta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA")
		})
	private FolheteriaDeta folheteriaDeta;

	public FolheteriaAnexo() {
	}

	public FolheteriaAnexoPK getId() {
		return this.id;
	}

	public void setId(FolheteriaAnexoPK id) {
		this.id = id;
	}

	public String getAnexo() {
		return this.anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
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

	public String getIdAnexo() {
		return this.idAnexo;
	}

	public void setIdAnexo(String idAnexo) {
		this.idAnexo = idAnexo;
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

	public String getNomeAnexo() {
		return this.nomeAnexo;
	}

	public void setNomeAnexo(String nomeAnexo) {
		this.nomeAnexo = nomeAnexo;
	}

	public Integer getTipoDocAnexado() {
		return this.tipoDocAnexado;
	}

	public void setTipoDocAnexado(Integer tipoDocAnexado) {
		this.tipoDocAnexado = tipoDocAnexado;
	}

	public FolheteriaDeta getFolheteriaDeta() {
		return this.folheteriaDeta;
	}

	public void setFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		this.folheteriaDeta = folheteriaDeta;
	}

}