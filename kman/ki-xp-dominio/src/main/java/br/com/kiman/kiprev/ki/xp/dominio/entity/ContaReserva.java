package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaReservaPK;

@IdClass(ContaReservaPK.class)
@Entity
@Table(name = "FO_TIPSALDOS_X_CUENTA", schema = "KIPREV")
public class ContaReserva {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;

	@Id
	@Column(name = "COD_TIPSALDO")
	private String codReserva;

	@Id
	@Column(name = "COD_INVERSION")
	private String codFundo;

	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;

	@Id
	@Column(name = "COD_OBJETIVO")
	private Long codObjetivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_INVERSION", referencedColumnName = "COD_INVERSION", insertable = false, updatable = false) })
	private Fundo fundo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Conta conta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TIPSALDO", referencedColumnName = "COD_TIPSALDO", insertable = false, updatable = false) })
	private Reserva reserva;

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Fundo getFundo() {
		return fundo;
	}

	public void setFundo(Fundo fundo) {
		this.fundo = fundo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getCodObjetivo() {
		return codObjetivo;
	}

	public void setCodObjetivo(Long codObjetivo) {
		this.codObjetivo = codObjetivo;
	}

	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	public String getCodFundo() {
		return codFundo;
	}

	public void setCodFundo(String codFundo) {
		this.codFundo = codFundo;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaReserva) {
			ContaReserva other = (ContaReserva) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codReserva, other.codReserva)
					.append(codFundo, other.codFundo)
					.append(codConta, other.codConta)
					.append(codObjetivo, other.codObjetivo).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codReserva)
				.append(codFundo).append(codConta).append(codObjetivo).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(codEmpresa).append(codReserva).append(codFundo)
				.append(codConta).append(codObjetivo).build();
	}

}
