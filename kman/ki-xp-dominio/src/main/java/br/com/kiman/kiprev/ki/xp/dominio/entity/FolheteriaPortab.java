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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaPortabPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_PORTAB database table.
 * 
 */
@Entity
@Table(schema = "KPVCUST11", name="INT_033_FOLHETERIA_PORTAB")
@NamedQuery(name="FolheteriaPortab.findAll", query="SELECT f FROM FolheteriaPortab f")
public class FolheteriaPortab implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaPortabPK id;

	@Column(name="COD_PORTABILIDADE")
	private String codPortabilidade;

	@Column(name="COD_SUSEP_FUNDO_DEST")
	private String codSusepFundoDest;

	@Column(name="COD_SUSEP_FUNDO_ORIG")
	private String codSusepFundoOrig;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MODIFICACAO")
	private Date dataModificacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_STATUS_PORTAB")
	private Date dataStatusPortab;

	@Column(name="INCLUIDO_POR")
	private String incluidoPor;

	@Column(name="MODALIDADE_DEST")
	private String modalidadeDest;

	@Column(name="MODALIDADE_ORIG")
	private String modalidadeOrig;

	@Column(name="MODIFICADO_POR")
	private String modificadoPor;

	@Column(name="NOME_PLANO_DEST")
	private String nomePlanoDest;

	@Column(name="NOME_PLANO_ORIG")
	private String nomePlanoOrig;

	@Column(name="REG_TRIBUTARIO_DEST")
	private String regTributarioDest;

	@Column(name="REG_TRIBUTARIO_ORIG")
	private String regTributarioOrig;

	@Column(name="STATUS_PORTABILIDADE")
	private Integer statusPortabilidade;

	@Column(name="TIPO_REGISTRO")
	private String tipoRegistro;

	@Column(name="VALOR_PORTABILIDADE")
	private BigDecimal valorPortabilidade;

	//bi-directional many-to-one association to FolheteriaFundoPrtb
	@OneToMany(mappedBy="folheteriaPortab")
	private List<FolheteriaFundoPrtb> folheteriaFundoPrtbs;

	//bi-directional many-to-one association to FolheteriaDeta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA")
		})
	private FolheteriaDeta folheteriaDeta;

	public FolheteriaPortab() {
	}

	public FolheteriaPortabPK getId() {
		return this.id;
	}

	public void setId(FolheteriaPortabPK id) {
		this.id = id;
	}

	public String getCodPortabilidade() {
		return this.codPortabilidade;
	}

	public void setCodPortabilidade(String codPortabilidade) {
		this.codPortabilidade = codPortabilidade;
	}

	public String getCodSusepFundoDest() {
		return this.codSusepFundoDest;
	}

	public void setCodSusepFundoDest(String codSusepFundoDest) {
		this.codSusepFundoDest = codSusepFundoDest;
	}

	public String getCodSusepFundoOrig() {
		return this.codSusepFundoOrig;
	}

	public void setCodSusepFundoOrig(String codSusepFundoOrig) {
		this.codSusepFundoOrig = codSusepFundoOrig;
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

	public Date getDataStatusPortab() {
		return this.dataStatusPortab;
	}

	public void setDataStatusPortab(Date dataStatusPortab) {
		this.dataStatusPortab = dataStatusPortab;
	}

	public String getIncluidoPor() {
		return this.incluidoPor;
	}

	public void setIncluidoPor(String incluidoPor) {
		this.incluidoPor = incluidoPor;
	}

	public String getModalidadeDest() {
		return this.modalidadeDest;
	}

	public void setModalidadeDest(String modalidadeDest) {
		this.modalidadeDest = modalidadeDest;
	}

	public String getModalidadeOrig() {
		return this.modalidadeOrig;
	}

	public void setModalidadeOrig(String modalidadeOrig) {
		this.modalidadeOrig = modalidadeOrig;
	}

	public String getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getNomePlanoDest() {
		return this.nomePlanoDest;
	}

	public void setNomePlanoDest(String nomePlanoDest) {
		this.nomePlanoDest = nomePlanoDest;
	}

	public String getNomePlanoOrig() {
		return this.nomePlanoOrig;
	}

	public void setNomePlanoOrig(String nomePlanoOrig) {
		this.nomePlanoOrig = nomePlanoOrig;
	}

	public String getRegTributarioDest() {
		return this.regTributarioDest;
	}

	public void setRegTributarioDest(String regTributarioDest) {
		this.regTributarioDest = regTributarioDest;
	}

	public String getRegTributarioOrig() {
		return this.regTributarioOrig;
	}

	public void setRegTributarioOrig(String regTributarioOrig) {
		this.regTributarioOrig = regTributarioOrig;
	}

	public Integer getStatusPortabilidade() {
		return this.statusPortabilidade;
	}

	public void setStatusPortabilidade(Integer statusPortabilidade) {
		this.statusPortabilidade = statusPortabilidade;
	}

	public String getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public BigDecimal getValorPortabilidade() {
		return this.valorPortabilidade;
	}

	public void setValorPortabilidade(BigDecimal valorPortabilidade) {
		this.valorPortabilidade = valorPortabilidade;
	}

	public List<FolheteriaFundoPrtb> getFolheteriaFundoPrtbs() {
		return this.folheteriaFundoPrtbs;
	}

	public void setFolheteriaFundoPrtbs(List<FolheteriaFundoPrtb> folheteriaFundoPrtbs) {
		this.folheteriaFundoPrtbs = folheteriaFundoPrtbs;
	}

	public FolheteriaFundoPrtb addFolheteriaFundoPrtb(FolheteriaFundoPrtb folheteriaFundoPrtb) {
		getFolheteriaFundoPrtbs().add(folheteriaFundoPrtb);
		folheteriaFundoPrtb.setFolheteriaPortab(this);

		return folheteriaFundoPrtb;
	}

	public FolheteriaFundoPrtb removeFolheteriaFundoPrtb(FolheteriaFundoPrtb folheteriaFundoPrtb) {
		getFolheteriaFundoPrtbs().remove(folheteriaFundoPrtb);
		folheteriaFundoPrtb.setFolheteriaPortab(null);

		return folheteriaFundoPrtb;
	}

	public FolheteriaDeta getFolheteriaDeta() {
		return this.folheteriaDeta;
	}

	public void setFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		this.folheteriaDeta = folheteriaDeta;
	}

}