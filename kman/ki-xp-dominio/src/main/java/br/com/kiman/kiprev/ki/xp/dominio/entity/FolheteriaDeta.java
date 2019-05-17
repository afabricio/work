package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaDetaPK;

/**
 * The persistent class for the INT_033_FOLHETERIA_DETA database table.
 * 
 */
@Entity
@Table(schema = "KPVCUST11", name = "INT_033_FOLHETERIA_DETA")

@NamedQueries(value = { @NamedQuery(name = "FolheteriaDeta.findAll", query = "SELECT f FROM FolheteriaDeta f"),
		@NamedQuery(name = FolheteriaDeta.QUERY_FIND_ALL_NOTSENT_BY_ENCA, query = "SELECT f FROM FolheteriaDeta f WHERE f.id.idEnca = :pIdEnca AND f.statusGer != 'S' ") })
public class FolheteriaDeta implements Serializable {

	private static final long serialVersionUID = -5814779172751886330L;
	public static final String QUERY_FIND_ALL_NOTSENT_BY_ENCA = "FolheteriaDeta.findAllNotSentByEnca";

	@EmbeddedId
	private FolheteriaDetaPK id;

	@Column(name = "COD_CERTIFICADO")
	private String codCertificado;

	@Column(name = "COD_PROPOSTA")
	private BigDecimal codProposta;

	@Column(name = "COD_SUSEP_FUNDO")
	private String codSusepFundo;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INCLUSAO")
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_MODIFICACAO")
	private Date dataModificacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PROCESSAMENTO")
	private Date dataProcessamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_SOLIC_CERT")
	private Date dataSolicCert;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_SOLIC_PROP")
	private Date dataSolicProp;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_STATUS_CERTIFICADO")
	private Date dataStatusCertificado;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_STATUS_PROPOSTA")
	private Date dataStatusProposta;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCTO_CERT")
	private Date dataVenctoCert;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_VENCTO_PROP")
	private Date dataVenctoProp;

	private String documento;

	private String email;

	@Column(name = "INCLUIDO_POR")
	private String incluidoPor;

	@Column(name = "IND_INF_RENDIMENTOS")
	private String indInfRendimentos;

	@Column(name = "IND_REL_CONTRIB")
	private String indRelContrib;

	@Column(name = "METODO_PAGTO_CERT")
	private String metodoPagtoCert;

	@Column(name = "METODO_PAGTO_PROP")
	private String metodoPagtoProp;

	private String modalidade;

	@Column(name = "MODIFICADO_POR")
	private String modificadoPor;

	private String nome;

	@Column(name = "NOME_PLANO")
	private String nomePlano;

	@Column(name = "REGIME_TRIBUTARIO")
	private String regimeTributario;

	@Column(name = "STATUS_CERTIFICADO")
	private Integer statusCertificado;

	@Column(name = "STATUS_GER")
	private String statusGer;

	@Column(name = "STATUS_PROPOSTA")
	private Integer statusProposta;

	@Column(name = "TEL_PRINCIPAL")
	private String telPrincipal;

	@Column(name = "TEL_SECUNDARIO")
	private String telSecundario;

	@Column(name = "TIPO_PAGTO_CERT")
	private Integer tipoPagtoCert;

	@Column(name = "TIPO_PAGTO_PROP")
	private Integer tipoPagtoProp;

	@Column(name = "VALOR_PAGTO_CERT")
	private BigDecimal valorPagtoCert;

	@Column(name = "VALOR_PAGTO_PROP")
	private BigDecimal valorPagtoProp;

	@Column(name = "VLR_TOTAL_FUNDO")
	private BigDecimal vlrTotalFundo;

	// bi-directional many-to-one association to FolheteriaAnexo
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaAnexo> folheteriaAnexos;

	// bi-directional many-to-one association to FolheteriaAtualizacao
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaAtualizacao> folheteriaAtualizacaos;

	// bi-directional many-to-one association to FolheteriaBenef
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaBenef> folheteriaBenefs;

	// bi-directional many-to-one association to FolheteriaEnca
	@ManyToOne
	@JoinColumn(name = "ID_ENCA")
	private FolheteriaEnca folheteriaEnca;

	// bi-directional many-to-one association to folheteriaFundo
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaFundo> folheteriaFundos;

	// bi-directional many-to-one association to FolheteriaPortab
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaPortab> folheteriaPortabs;

	// bi-directional many-to-one association to folheteriaReservaFun
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaReservaFun> folheteriaReservaFuns;

	// bi-directional many-to-one association to FolheteriaTransFinan
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaTransFinan> folheteriaTransFinans;

	// bi-directional many-to-one association to folheteriaDistribFun
	@OneToMany(mappedBy = "folheteriaDeta")
	private List<FolheteriaDistribFun> folheteriaDistribFuns;

	public FolheteriaDeta() {
	}

	public FolheteriaDetaPK getId() {
		return this.id;
	}

	public void setId(FolheteriaDetaPK id) {
		this.id = id;
	}

	public String getCodCertificado() {
		return this.codCertificado;
	}

	public void setCodCertificado(String codCertificado) {
		this.codCertificado = codCertificado;
	}

	public BigDecimal getCodProposta() {
		return this.codProposta;
	}

	public void setCodProposta(BigDecimal codProposta) {
		this.codProposta = codProposta;
	}

	public String getCodSusepFundo() {
		return this.codSusepFundo;
	}

	public void setCodSusepFundo(String codSusepFundo) {
		this.codSusepFundo = codSusepFundo;
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

	public Date getDataSolicCert() {
		return this.dataSolicCert;
	}

	public void setDataSolicCert(Date dataSolicCert) {
		this.dataSolicCert = dataSolicCert;
	}

	public Date getDataSolicProp() {
		return this.dataSolicProp;
	}

	public void setDataSolicProp(Date dataSolicProp) {
		this.dataSolicProp = dataSolicProp;
	}

	public Date getDataStatusCertificado() {
		return this.dataStatusCertificado;
	}

	public void setDataStatusCertificado(Date dataStatusCertificado) {
		this.dataStatusCertificado = dataStatusCertificado;
	}

	public Date getDataStatusProposta() {
		return this.dataStatusProposta;
	}

	public void setDataStatusProposta(Date dataStatusProposta) {
		this.dataStatusProposta = dataStatusProposta;
	}

	public Date getDataVenctoCert() {
		return this.dataVenctoCert;
	}

	public void setDataVenctoCert(Date dataVenctoCert) {
		this.dataVenctoCert = dataVenctoCert;
	}

	public Date getDataVenctoProp() {
		return this.dataVenctoProp;
	}

	public void setDataVenctoProp(Date dataVenctoProp) {
		this.dataVenctoProp = dataVenctoProp;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIncluidoPor() {
		return this.incluidoPor;
	}

	public void setIncluidoPor(String incluidoPor) {
		this.incluidoPor = incluidoPor;
	}

	public String getIndInfRendimentos() {
		return this.indInfRendimentos;
	}

	public void setIndInfRendimentos(String indInfRendimentos) {
		this.indInfRendimentos = indInfRendimentos;
	}

	public String getIndRelContrib() {
		return this.indRelContrib;
	}

	public void setIndRelContrib(String indRelContrib) {
		this.indRelContrib = indRelContrib;
	}

	public String getMetodoPagtoCert() {
		return this.metodoPagtoCert;
	}

	public void setMetodoPagtoCert(String metodoPagtoCert) {
		this.metodoPagtoCert = metodoPagtoCert;
	}

	public String getMetodoPagtoProp() {
		return this.metodoPagtoProp;
	}

	public void setMetodoPagtoProp(String metodoPagtoProp) {
		this.metodoPagtoProp = metodoPagtoProp;
	}

	public String getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePlano() {
		return this.nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public String getRegimeTributario() {
		return this.regimeTributario;
	}

	public void setRegimeTributario(String regimeTributario) {
		this.regimeTributario = regimeTributario;
	}

	public Integer getStatusCertificado() {
		return this.statusCertificado;
	}

	public void setStatusCertificado(Integer statusCertificado) {
		this.statusCertificado = statusCertificado;
	}

	public String getStatusGer() {
		return this.statusGer;
	}

	public void setStatusGer(String statusGer) {
		this.statusGer = statusGer;
	}

	public Integer getStatusProposta() {
		return this.statusProposta;
	}

	public void setStatusProposta(Integer statusProposta) {
		this.statusProposta = statusProposta;
	}

	public String getTelPrincipal() {
		return this.telPrincipal;
	}

	public void setTelPrincipal(String telPrincipal) {
		this.telPrincipal = telPrincipal;
	}

	public String getTelSecundario() {
		return this.telSecundario;
	}

	public void setTelSecundario(String telSecundario) {
		this.telSecundario = telSecundario;
	}

	public Integer getTipoPagtoCert() {
		return this.tipoPagtoCert;
	}

	public void setTipoPagtoCert(Integer tipoPagtoCert) {
		this.tipoPagtoCert = tipoPagtoCert;
	}

	public Integer getTipoPagtoProp() {
		return this.tipoPagtoProp;
	}

	public void setTipoPagtoProp(Integer tipoPagtoProp) {
		this.tipoPagtoProp = tipoPagtoProp;
	}

	public BigDecimal getValorPagtoCert() {
		return this.valorPagtoCert;
	}

	public void setValorPagtoCert(BigDecimal valorPagtoCert) {
		this.valorPagtoCert = valorPagtoCert;
	}

	public BigDecimal getValorPagtoProp() {
		return this.valorPagtoProp;
	}

	public void setValorPagtoProp(BigDecimal valorPagtoProp) {
		this.valorPagtoProp = valorPagtoProp;
	}

	public BigDecimal getVlrTotalFundo() {
		return this.vlrTotalFundo;
	}

	public void setVlrTotalFundo(BigDecimal vlrTotalFundo) {
		this.vlrTotalFundo = vlrTotalFundo;
	}

	public List<FolheteriaAnexo> getFolheteriaAnexos() {
		return this.folheteriaAnexos;
	}

	public void setFolheteriaAnexos(List<FolheteriaAnexo> folheteriaAnexos) {
		this.folheteriaAnexos = folheteriaAnexos;
	}

	public FolheteriaAnexo addFolheteriaAnexo(FolheteriaAnexo folheteriaAnexo) {
		getFolheteriaAnexos().add(folheteriaAnexo);
		folheteriaAnexo.setFolheteriaDeta(this);

		return folheteriaAnexo;
	}

	public FolheteriaAnexo removeFolheteriaAnexo(FolheteriaAnexo folheteriaAnexo) {
		getFolheteriaAnexos().remove(folheteriaAnexo);
		folheteriaAnexo.setFolheteriaDeta(null);

		return folheteriaAnexo;
	}

	public List<FolheteriaAtualizacao> getFolheteriaAtualizacaos() {
		return this.folheteriaAtualizacaos;
	}

	public void setFolheteriaAtualizacaos(List<FolheteriaAtualizacao> folheteriaAtualizacaos) {
		this.folheteriaAtualizacaos = folheteriaAtualizacaos;
	}

	public FolheteriaAtualizacao addFolheteriaAtualizacao(FolheteriaAtualizacao folheteriaAtualizacao) {
		getFolheteriaAtualizacaos().add(folheteriaAtualizacao);
		folheteriaAtualizacao.setFolheteriaDeta(this);

		return folheteriaAtualizacao;
	}

	public FolheteriaAtualizacao removeFolheteriaAtualizacao(FolheteriaAtualizacao folheteriaAtualizacao) {
		getFolheteriaAtualizacaos().remove(folheteriaAtualizacao);
		folheteriaAtualizacao.setFolheteriaDeta(null);

		return folheteriaAtualizacao;
	}

	public List<FolheteriaBenef> getFolheteriaBenefs() {
		return this.folheteriaBenefs;
	}

	public void setFolheteriaBenefs(List<FolheteriaBenef> folheteriaBenefs) {
		this.folheteriaBenefs = folheteriaBenefs;
	}

	public FolheteriaBenef addFolheteriaBenef(FolheteriaBenef folheteriaBenef) {
		getFolheteriaBenefs().add(folheteriaBenef);
		folheteriaBenef.setFolheteriaDeta(this);

		return folheteriaBenef;
	}

	public FolheteriaBenef removeFolheteriaBenef(FolheteriaBenef folheteriaBenef) {
		getFolheteriaBenefs().remove(folheteriaBenef);
		folheteriaBenef.setFolheteriaDeta(null);

		return folheteriaBenef;
	}

	public FolheteriaEnca getFolheteriaEnca() {
		return this.folheteriaEnca;
	}

	public void setFolheteriaEnca(FolheteriaEnca folheteriaEnca) {
		this.folheteriaEnca = folheteriaEnca;
	}

	public List<FolheteriaFundo> getFolheteriaFundos() {
		return this.folheteriaFundos;
	}

	public void setFolheteriaFundos(List<FolheteriaFundo> folheteriaFundos) {
		this.folheteriaFundos = folheteriaFundos;
	}

	public FolheteriaFundo addFolheteriaFundo(FolheteriaFundo folheteriaFundo) {
		getFolheteriaFundos().add(folheteriaFundo);
		folheteriaFundo.setFolheteriaDeta(this);

		return folheteriaFundo;
	}

	public FolheteriaFundo removeFolheteriaFundo(FolheteriaFundo folheteriaFundo) {
		getFolheteriaFundos().remove(folheteriaFundo);
		folheteriaFundo.setFolheteriaDeta(null);

		return folheteriaFundo;
	}

	public List<FolheteriaPortab> getFolheteriaPortabs() {
		return this.folheteriaPortabs;
	}

	public void setFolheteriaPortabs(List<FolheteriaPortab> folheteriaPortabs) {
		this.folheteriaPortabs = folheteriaPortabs;
	}

	public FolheteriaPortab addFolheteriaPortab(FolheteriaPortab folheteriaPortab) {
		getFolheteriaPortabs().add(folheteriaPortab);
		folheteriaPortab.setFolheteriaDeta(this);

		return folheteriaPortab;
	}

	public FolheteriaPortab removeFolheteriaPortab(FolheteriaPortab folheteriaPortab) {
		getFolheteriaPortabs().remove(folheteriaPortab);
		folheteriaPortab.setFolheteriaDeta(null);

		return folheteriaPortab;
	}

	public List<FolheteriaReservaFun> getFolheteriaReservaFuns() {
		return this.folheteriaReservaFuns;
	}

	public void setFolheteriaReservaFuns(List<FolheteriaReservaFun> folheteriaReservaFuns) {
		this.folheteriaReservaFuns = folheteriaReservaFuns;
	}

	public FolheteriaReservaFun addFolheteriaReservaFun(FolheteriaReservaFun folheteriaReservaFun) {
		getFolheteriaReservaFuns().add(folheteriaReservaFun);
		folheteriaReservaFun.setFolheteriaDeta(this);

		return folheteriaReservaFun;
	}

	public FolheteriaReservaFun removeFolheteriaReservaFun(FolheteriaReservaFun folheteriaReservaFun) {
		getFolheteriaReservaFuns().remove(folheteriaReservaFun);
		folheteriaReservaFun.setFolheteriaDeta(null);

		return folheteriaReservaFun;
	}

	public List<FolheteriaTransFinan> getFolheteriaTransFinans() {
		return this.folheteriaTransFinans;
	}

	public void setFolheteriaTransFinans(List<FolheteriaTransFinan> folheteriaTransFinans) {
		this.folheteriaTransFinans = folheteriaTransFinans;
	}

	public FolheteriaTransFinan addFolheteriaTransFinan(FolheteriaTransFinan folheteriaTransFinan) {
		getFolheteriaTransFinans().add(folheteriaTransFinan);
		folheteriaTransFinan.setFolheteriaDeta(this);

		return folheteriaTransFinan;
	}

	public FolheteriaTransFinan removeFolheteriaTransFinan(FolheteriaTransFinan folheteriaTransFinan) {
		getFolheteriaTransFinans().remove(folheteriaTransFinan);
		folheteriaTransFinan.setFolheteriaDeta(null);

		return folheteriaTransFinan;
	}

	public List<FolheteriaDistribFun> getFolheteriaDistribFuns() {
		return this.folheteriaDistribFuns;
	}

	public void setFolheteriaDistribFuns(List<FolheteriaDistribFun> folheteriaDistribFuns) {
		this.folheteriaDistribFuns = folheteriaDistribFuns;
	}

	public FolheteriaDistribFun addFolheteriaDistribFun(FolheteriaDistribFun folheteriaDistribFun) {
		getFolheteriaDistribFuns().add(folheteriaDistribFun);
		folheteriaDistribFun.setFolheteriaDeta(this);

		return folheteriaDistribFun;
	}

	public FolheteriaDistribFun removeFolheteriaDistribFun(FolheteriaDistribFun folheteriaDistribFun) {
		getFolheteriaDistribFuns().remove(folheteriaDistribFun);
		folheteriaDistribFun.setFolheteriaDeta(null);

		return folheteriaDistribFun;
	}

}