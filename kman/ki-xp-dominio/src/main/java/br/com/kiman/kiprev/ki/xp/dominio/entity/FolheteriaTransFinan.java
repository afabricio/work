package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaTransFinanPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_TRANS_FINAN database table.
 * 
 */
@Entity
@Table(schema = "KPVCUST11", name="INT_033_FOLHETERIA_TRANS_FINAN")
@NamedQuery(name="FolheteriaTransFinan.findAll", query="SELECT f FROM FolheteriaTransFinan f")
public class FolheteriaTransFinan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaTransFinanPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_SOLIC")
	private Date dataSolic;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_STATUS_TRANSACAO")
	private Date dataStatusTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_VENCTO")
	private Date dataVencto;

	@Column(name="ID_TRANSACAO")
	private String idTransacao;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="METODO_PAGTO")
	private String metodoPagto;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	@Column(name="STATUS_TRANSACAO")
	private Integer statusTransacao;

	@Column(name="TIPO_PAGTO")
	private Integer tipoPagto;

	@Column(name="TIPO_TRANSACAO")
	private Integer tipoTransacao;

	@Column(name="VALOR_PAGTO")
	private BigDecimal valorPagto;

	//bi-directional many-to-one association to FolheteriaContribFun
	@OneToMany(mappedBy="folheteriaTransFinan")
	private List<FolheteriaContribFun> folheteriaContribFuns;

	//bi-directional many-to-one association to FolheteriaDeta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA")
		})
	private FolheteriaDeta folheteriaDeta;

	public FolheteriaTransFinan() {
	}

	public FolheteriaTransFinanPK getId() {
		return this.id;
	}

	public void setId(FolheteriaTransFinanPK id) {
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

	public Date getDataSolic() {
		return this.dataSolic;
	}

	public void setDataSolic(Date dataSolic) {
		this.dataSolic = dataSolic;
	}

	public Date getDataStatusTransacao() {
		return this.dataStatusTransacao;
	}

	public void setDataStatusTransacao(Date dataStatusTransacao) {
		this.dataStatusTransacao = dataStatusTransacao;
	}

	public Date getDataVencto() {
		return this.dataVencto;
	}

	public void setDataVencto(Date dataVencto) {
		this.dataVencto = dataVencto;
	}

	public String getIdTransacao() {
		return this.idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getIncluidoPor() {
		return this.incluidoPor;
	}

	public void setIncluidoPor(String incluidoPor) {
		this.incluidoPor = incluidoPor;
	}

	public String getMetodoPagto() {
		return this.metodoPagto;
	}

	public void setMetodoPagto(String metodoPagto) {
		this.metodoPagto = metodoPagto;
	}

	public String getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Integer getStatusTransacao() {
		return this.statusTransacao;
	}

	public void setStatusTransacao(Integer statusTransacao) {
		this.statusTransacao = statusTransacao;
	}

	public Integer getTipoPagto() {
		return this.tipoPagto;
	}

	public void setTipoPagto(Integer tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Integer getTipoTransacao() {
		return this.tipoTransacao;
	}

	public void setTipoTransacao(Integer tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public BigDecimal getValorPagto() {
		return this.valorPagto;
	}

	public void setValorPagto(BigDecimal valorPagto) {
		this.valorPagto = valorPagto;
	}

	public List<FolheteriaContribFun> getFolheteriaContribFuns() {
		return this.folheteriaContribFuns;
	}

	public void setFolheteriaContribFuns(List<FolheteriaContribFun> folheteriaContribFuns) {
		this.folheteriaContribFuns = folheteriaContribFuns;
	}

	public FolheteriaContribFun addFolheteriaContribFun(FolheteriaContribFun folheteriaContribFun) {
		getFolheteriaContribFuns().add(folheteriaContribFun);
		folheteriaContribFun.setFolheteriaTransFinan(this);

		return folheteriaContribFun;
	}

	public FolheteriaContribFun removeFolheteriaContribFun(FolheteriaContribFun folheteriaContribFun) {
		getFolheteriaContribFuns().remove(folheteriaContribFun);
		folheteriaContribFun.setFolheteriaTransFinan(null);

		return folheteriaContribFun;
	}

	public FolheteriaDeta getFolheteriaDeta() {
		return this.folheteriaDeta;
	}

	public void setFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		this.folheteriaDeta = folheteriaDeta;
	}

}