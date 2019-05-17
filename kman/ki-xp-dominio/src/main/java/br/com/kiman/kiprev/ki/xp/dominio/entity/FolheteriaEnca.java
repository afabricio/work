package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the INT_033_FOLHETERIA_ENCA database table.
 * 
 */
@Entity
@Table(schema="KPVCUST11", name = "INT_033_FOLHETERIA_ENCA")
@NamedQueries(value = {
		@NamedQuery(name =FolheteriaEnca.QUERY_FIND_ALL_NOTSENT, query = "SELECT f FROM FolheteriaEnca f WHERE f.statusGer !='S' order by f.dataInclusao "),
		@NamedQuery(name = FolheteriaEnca.QUERY_FIND_ALL, query = "SELECT f FROM FolheteriaEnca f") })
public class FolheteriaEnca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String QUERY_FIND_ALL_NOTSENT = "FolheteriaEnca.findNotSent";
	public static final String QUERY_FIND_ALL = "FolheteriaEnca.findAll";
	@Id
	@Column(name="ID_ENCA")
	private long idEnca;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CALENDARIO")
	private Date dataCalendario;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PROCESSAMENTO")
	private Date dataProcessamento;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	@Column(name="STATUS_GER")
	private String statusGer;

	//bi-directional many-to-one association to FolheteriaDeta
	@OneToMany(mappedBy="folheteriaEnca")
	private List<FolheteriaDeta> folheteriaDetas;

	public FolheteriaEnca() {
	}

	public long getIdEnca() {
		return this.idEnca;
	}

	public void setIdEnca(long idEnca) {
		this.idEnca = idEnca;
	}

	public Date getDataCalendario() {
		return this.dataCalendario;
	}

	public void setDataCalendario(Date dataCalendario) {
		this.dataCalendario = dataCalendario;
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

	public Date getDataProcessamento() {
		return this.dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
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

	public String getStatusGer() {
		return this.statusGer;
	}

	public void setStatusGer(String statusGer) {
		this.statusGer = statusGer;
	}

	public List<FolheteriaDeta> getFolheteriaDetas() {
		return this.folheteriaDetas;
	}

	public void setFolheteriaDetas(List<FolheteriaDeta> folheteriaDetas) {
		this.folheteriaDetas = folheteriaDetas;
	}

	public FolheteriaDeta addFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		getFolheteriaDetas().add(folheteriaDeta);
		folheteriaDeta.setFolheteriaEnca(this);

		return folheteriaDeta;
	}

	public FolheteriaDeta removeFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		getFolheteriaDetas().remove(folheteriaDeta);
		folheteriaDeta.setFolheteriaEnca(null);

		return folheteriaDeta;
	}

}