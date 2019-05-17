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

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.FolheteriaReservaFunPK;


/**
 * The persistent class for the INT_033_FOLHETERIA_RESERVA_FUN database table.
 * 
 */
@Entity
@Table(schema = "KPVCUST11", name="INT_033_FOLHETERIA_RESERVA_FUN")
@NamedQuery(name="FolheteriaReservaFun.findAll", query="SELECT i FROM FolheteriaReservaFun i")
public class FolheteriaReservaFun implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FolheteriaReservaFunPK id;

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

	@Column(name="QTD_COTA")
	private BigDecimal qtdCota;

	@Column(name="VLR_SALDO")
	private BigDecimal vlrSaldo;

	@Column(name="VLR_UNIT_COTA")
	private BigDecimal vlrUnitCota;

	//bi-directional many-to-one association to FolheteriaDeta
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_DETA", referencedColumnName="ID_DETA"),
		@JoinColumn(name="ID_ENCA", referencedColumnName="ID_ENCA")
		})
	private FolheteriaDeta folheteriaDeta;

	public FolheteriaReservaFun() {
	}

	public FolheteriaReservaFunPK getId() {
		return this.id;
	}

	public void setId(FolheteriaReservaFunPK id) {
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

	public BigDecimal getQtdCota() {
		return this.qtdCota;
	}

	public void setQtdCota(BigDecimal qtdCota) {
		this.qtdCota = qtdCota;
	}

	public BigDecimal getVlrSaldo() {
		return this.vlrSaldo;
	}

	public void setVlrSaldo(BigDecimal vlrSaldo) {
		this.vlrSaldo = vlrSaldo;
	}

	public BigDecimal getVlrUnitCota() {
		return this.vlrUnitCota;
	}

	public void setVlrUnitCota(BigDecimal vlrUnitCota) {
		this.vlrUnitCota = vlrUnitCota;
	}

	public FolheteriaDeta getFolheteriaDeta() {
		return this.folheteriaDeta;
	}

	public void setFolheteriaDeta(FolheteriaDeta folheteriaDeta) {
		this.folheteriaDeta = folheteriaDeta;
	}

}