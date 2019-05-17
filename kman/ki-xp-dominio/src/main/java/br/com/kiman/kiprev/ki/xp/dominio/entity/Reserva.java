package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoCategoriaReservaEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoOrigemReservaEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ReservaPK;

@IdClass(ReservaPK.class)
@Entity
@Table(name = "FO_TIPSALDOS", schema = "KIPREV")
public class Reserva {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_TIPSALDO")
	private String codReserva;
	@Column(name = "DESCRIPCION")
	private String descReserva;
	@Column(name = "CAT_RESERVA")
	private TipoCategoriaReservaEnum tipoCategoriaReserva;
	@Column(name = "ORIGEN_TIPSALDO")
	private TipoOrigemReservaEnum tipoOrigemReserva;
	@Column(name = "ind_reserva")
	private String indReserva;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "KIPREV.FO_TIPSALDOS_X_CLASSIF", joinColumns = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_TIPSALDO", referencedColumnName = "COD_TIPSALDO", insertable = false, updatable = false) })
	private List<ReservaPorClassificacao> listaClassificacao;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA"),
			@JoinColumn(name = "COD_TIPSALDO", referencedColumnName = "COD_TIPSALDO") })
	private List<ContaReserva> listaContaReserva;

	public List<ReservaPorClassificacao> getListaClassificacao() {
		return listaClassificacao;
	}

	public void setListaClassificacao(
			List<ReservaPorClassificacao> listaClassificacao) {
		this.listaClassificacao = listaClassificacao;
	}

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

	public String getDescReserva() {
		return descReserva;
	}

	public void setDescReserva(String descReserva) {
		this.descReserva = descReserva;
	}

	public List<ContaReserva> getListaContaReserva() {
		return listaContaReserva;
	}

	public void setListaContaReserva(List<ContaReserva> listaContaReserva) {
		this.listaContaReserva = listaContaReserva;
	}

	public String getIndReserva() {
		return indReserva;
	}

	public void setIndReserva(String indReserva) {
		this.indReserva = indReserva;
	}

	public TipoCategoriaReservaEnum getTipoCategoriaReserva() {
		return tipoCategoriaReserva;
	}

	public void setTipoCategoriaReserva(
			TipoCategoriaReservaEnum tipoCategoriaReserva) {
		this.tipoCategoriaReserva = tipoCategoriaReserva;
	}

	public TipoOrigemReservaEnum getTipoOrigemReserva() {
		return tipoOrigemReserva;
	}

	public void setTipoOrigemReserva(TipoOrigemReservaEnum tipoOrigemReserva) {
		this.tipoOrigemReserva = tipoOrigemReserva;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codReserva)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Reserva) {
			Reserva status = (Reserva) obj;
			return new EqualsBuilder().append(codEmpresa, status.codEmpresa)
					.append(codReserva, status.codReserva).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codReserva).build();
	}
}