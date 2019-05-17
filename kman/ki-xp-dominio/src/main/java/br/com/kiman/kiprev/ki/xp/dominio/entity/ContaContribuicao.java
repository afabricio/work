package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;

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

import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusContaContribuicaoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaContribuicaoPK;

@Entity
@IdClass(ContaContribuicaoPK.class)
@Table(schema = "KIPREV", name = "FO_CONTRIB_X_CONTA")
public class ContaContribuicao {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codCertificado;
	@Id
	@Column(name = "COD_CONTRIB")
	private String codContribuicao;
	@Id
	@Column(name = "PRIMEIRO_APORTE")
	private String primeiroAporte;
	@Column(name = "DATA_COMPETENCIA")
	private LocalDate dataCompetencia;
	@Column(name = "DIA_PAGAMENTO")
	private Long diaPagamento;
	@Column(name = "APORTE_ESPERADO")
	private Double valorAporteEsperado;
	@Column(name = "APORTE_CONTRATADO")
	private Double valorAporteContratado;
	@Column(name = "STATUS_CONTRIB")
	private StatusContaContribuicaoEnum status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PESSOA", referencedColumnName = "COD_PESSOA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CANAL", referencedColumnName = "COD_CANAL", insertable = false, updatable = false) })
	private CanalPagamentoPessoa canalPagamentoPessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTRIB", referencedColumnName = "COD_CONTRIB", insertable = false, updatable = false) })
	private Contribuicao contribuicao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false) })
	private ContaBeneficio contaBeneficio;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodCertificado() {
		return codCertificado;
	}

	public void setCodCertificado(String codCertificado) {
		this.codCertificado = codCertificado;
	}

	public String getCodContribuicao() {
		return codContribuicao;
	}

	public void setCodContribuicao(String codContribuicao) {
		this.codContribuicao = codContribuicao;
	}

//	public Boolean getIndPrimeiroAporte() {
//		return new BooleanConverter().convertToEntityAttribute(primeiroAporte);
//	}
//
//	public void setIndPrimeiroAporte(Boolean indPrimeiroAporte) {
//		this.primeiroAporte = new BooleanConverter()
//				.convertToDatabaseColumn(indPrimeiroAporte);
//	}

	public CanalPagamentoPessoa getCanalPagamentoPessoa() {
		return canalPagamentoPessoa;
	}

	public void setCanalPagamentoPessoa(
			CanalPagamentoPessoa canalPagamentoPessoa) {
		this.canalPagamentoPessoa = canalPagamentoPessoa;
	}

	public Contribuicao getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(Contribuicao contribuicao) {
		this.contribuicao = contribuicao;
	}

	public String getPrimeiroAporte() {
		return primeiroAporte;
	}

	public void setPrimeiroAporte(String primeiroAporte) {
		this.primeiroAporte = primeiroAporte;
	}

	public LocalDate getDataCompetencia() {
		return dataCompetencia;
	}

	public void setDataCompetencia(LocalDate dataCompetencia) {
		this.dataCompetencia = dataCompetencia;
	}

	public Long getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(Long diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public Double getValorAporteEsperado() {
		return valorAporteEsperado != null ? valorAporteEsperado : 0d;
	}

	public void setValorAporteEsperado(Double valorAporteEsperado) {
		this.valorAporteEsperado = valorAporteEsperado;
	}

	public Double getValorAporteContratado() {
		return valorAporteContratado;
	}

	public void setValorAporteContratado(Double valorAporteContratado) {
		this.valorAporteContratado = valorAporteContratado;
	}

	public boolean isRegular() {
		return contribuicao.isRegular();
	}

	public boolean isPortabilidade() {
		return contribuicao.isPortabilidade();
	}

	public StatusContaContribuicaoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusContaContribuicaoEnum status) {
		this.status = status;
	}

	public ContaBeneficio getContaBeneficio() {
		return contaBeneficio;
	}

	public void setContaBeneficio(ContaBeneficio contaBeneficio) {
		this.contaBeneficio = contaBeneficio;
	}

	public boolean isAtiva() {
		return StatusContaContribuicaoEnum.ATIVO.equals(status);
	}

	public boolean isEsporadica() {
		return contribuicao.isEsporadica();
	}

	public boolean isInicial() {
		return contribuicao.isInicial();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaContribuicao) {
			ContaContribuicao other = (ContaContribuicao) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codCertificado, other.codCertificado)
					.append(codContribuicao, other.codContribuicao)
					.append(primeiroAporte, other.primeiroAporte).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codCertificado)
				.append(codContribuicao).append(primeiroAporte).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codCertificado)
				.append(codContribuicao).append(primeiroAporte).build();
	}

}
