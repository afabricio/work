package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ReservaPorClassificacaoPK;

@Entity
@IdClass(ReservaPorClassificacaoPK.class)
@Table(name = "FO_TIPSALDOS_X_CLASSIF", schema = "KIPREV")
public class ReservaPorClassificacao {

	
	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	
	@Id
	@Column(name = "COD_TIPSALDO")
	private String codReserva;

	@Id
	@Column(name = "COD_CLASSIFICACAO")
	private String codClassificacao;
	
	
	@ManyToOne
	@JoinColumns(value = { @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA",insertable=false, updatable=false),
			@JoinColumn(name = "COD_TIPSALDO", referencedColumnName = "COD_TIPSALDO",insertable=false, updatable=false) })
	private Reserva reserva;
	
	@ManyToOne
	@JoinColumns(value = { @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA",insertable=false, updatable=false),
			@JoinColumn(name = "COD_CLASSIFICACAO", referencedColumnName = "COD_CLASSIFICACAO",insertable=false, updatable=false) })
	private ClassificacaoReserva classificacao;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	
	
	

	public String getCodClassificacao() {
		return codClassificacao;
	}

	public void setCodClassificacao(String codClassificacao) {
		this.codClassificacao = codClassificacao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public ClassificacaoReserva getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoReserva classificacao) {
		this.classificacao = classificacao;
	}
	


	
	


}
