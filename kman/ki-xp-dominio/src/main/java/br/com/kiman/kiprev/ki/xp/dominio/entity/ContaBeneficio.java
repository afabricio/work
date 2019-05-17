package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaBeneficioPK;

@Entity
@IdClass(ContaBeneficioPK.class)
@Table(schema = "KIPREV", name = "BENEFICIOS_X_CUENTA")
//@NamedQueries(value = @NamedQuery(name = JPQLs.N_CONTA_BENEFICIO_POR_CONTA, query = JPQLs.Q_CONTA_BENEFICIO_POR_CONTA))
public class ContaBeneficio {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Id
	@Column(name = "COD_PLAN")
	private Long codPlano;
	@Id
	@Column(name = "COD_BENEFICIO")
	private Long codBeneficio;
	@Column(name = "MON_BENEFICIO")
	private Double valorBeneficio;
	@Column(name = "IND_PRINCIPAL")
	private Boolean indPrincipal;
	@Column(name = "PLAZO")
	private Long prazo;
	@Column(name = "PRAZO_DESEJADO_PROG")
	private Long prazoProgramado;
	@Column(name = "DT_INI_VIG")
	private LocalDate inicioVigencia;
	@Column(name = "DT_FIM_VIG")
	private LocalDate fimVigencia;
	@Column(name = "PCT_REVERSAO")
	private Double percentualReversao;
	@Column(name = "IND_TREZE_RENDAS")
	private Boolean indTrezeRendas;
	@Column(name = "COD_ESTADO")
	private String codStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false) })
	private Beneficio beneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "TIP_PAGO", referencedColumnName = "TIP_PAGO", insertable = false, updatable = false) })
	private TipoPagamentoBeneficio tipoPagamentoBeneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "TIP_STATUS", referencedColumnName = "TIP_STATUS", insertable = false, updatable = false),
			@JoinColumn(name = "COD_ESTADO", referencedColumnName = "COD_STATUS", insertable = false, updatable = false),
			@JoinColumn(name = "COD_SUB_ESTADO", referencedColumnName = "COD_SUB_STATUS", insertable = false, updatable = false) })
	private SubStatus subStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Conta conta;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false), })
	private Set<BeneficiarioBeneficio> beneficiarios = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contaBeneficio")
	private Set<ContaContribuicao> contribuicoes = Sets.newHashSet();

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodConta() {
		return codConta;
	}

	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}

	public Long getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(Long codPlano) {
		this.codPlano = codPlano;
	}

	public Long getCodBeneficio() {
		return codBeneficio;
	}

	public void setCodBeneficio(Long codBeneficio) {
		this.codBeneficio = codBeneficio;
	}

	public Double getValorBeneficio() {
		return valorBeneficio;
	}

	public void setValorBeneficio(Double valorBeneficio) {
		this.valorBeneficio = valorBeneficio;
	}

	public Boolean getIndPrincipal() {
		return indPrincipal;
	}

	public void setIndPrincipal(Boolean indPrincipal) {
		this.indPrincipal = indPrincipal;
	}

	public Long getPrazo() {
		return prazo;
	}

	public void setPrazo(Long prazo) {
		this.prazo = prazo;
	}

	public LocalDate getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(LocalDate inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public LocalDate getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(LocalDate fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Double getPercentualReversao() {
		return percentualReversao;
	}

	public void setPercentualReversao(Double percentualReversao) {
		this.percentualReversao = percentualReversao;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public TipoPagamentoBeneficio getTipoPagamentoBeneficio() {
		return tipoPagamentoBeneficio;
	}

	public void setTipoPagamentoBeneficio(
			TipoPagamentoBeneficio tipoPagamentoBeneficio) {
		this.tipoPagamentoBeneficio = tipoPagamentoBeneficio;
	}

	public SubStatus getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(SubStatus subStatus) {
		this.subStatus = subStatus;
	}

	public Boolean getIndTrezeRendas() {
		return indTrezeRendas;
	}

	public void setIndTrezeRendas(Boolean indTrezeRendas) {
		this.indTrezeRendas = indTrezeRendas;
	}

	public Long getPrazoProgramado() {
		return prazoProgramado;
	}

	public void setPrazoProgramado(Long prazoProgramdo) {
		this.prazoProgramado = prazoProgramdo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Set<BeneficiarioBeneficio> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Set<BeneficiarioBeneficio> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public boolean isSobrevivencia() {
		return beneficio != null && beneficio.isSobrevivencia();
	}

	public boolean isRisco() {
		return beneficio != null && beneficio.isRisco();
	}

	public Double getValorContribuicao() {
		return contribuicoes.stream().mapToDouble(c -> {
			if (c.isAtiva() && c.isRegular()) {
				return c.getValorAporteEsperado();
			}
			return 0d;
		}).sum();
	}

//	public PeriodicidadePagamento getPeriodicidade() {
//		return hasContribuicaoRegular();
//	}
//
//	private PeriodicidadePagamento hasContribuicaoRegular() {
//		return contribuicoes.stream().filter(c -> c.isAtiva() && c.isRegular())
//				.findFirst().map(c -> PeriodicidadePagamento.MENSAL)
//				.orElse(null);
//	}

	public String getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(String codStatus) {
		this.codStatus = codStatus;
	}

	public Set<ContaContribuicao> getContribuicoes() {
		return contribuicoes;
	}

	public void setContribuicoes(Set<ContaContribuicao> contribuicoes) {
		this.contribuicoes = contribuicoes;
	}

	public ContaContribuicao getContribuicaoRegular() {
		return contribuicoes.stream().filter(c -> c.isRegular()).findFirst()
				.orElse(null);
	}

	public ContaContribuicao getContribuicaoEsporadica() {
		return contribuicoes.stream().filter(c -> c.isEsporadica()).findFirst()
				.orElse(null);
	}

	public ContaContribuicao getContribuicaoPortabilidade() {
		return contribuicoes.stream().filter(c -> c.isPortabilidade())
				.findFirst().orElse(null);
	}

	public List<ContaContribuicao> getContribuicoesRegularesAtivas() {
		return contribuicoes.stream().filter(c -> c.isRegular() && c.isAtiva())
				.collect(Collectors.toList());
	}

	public Double getValorContribuicoesRegularesAtivas() {
		return getContribuicoesRegularesAtivas().stream()
				.mapToDouble(c -> c.getValorAporteEsperado()).sum();
	}

	public Double getValorContribuicoesIniciais() {
		return getContribuicoesIniciais().stream()
				.mapToDouble(c -> c.getValorAporteEsperado()).sum();
	}

	private List<ContaContribuicao> getContribuicoesIniciais() {
		return contribuicoes.stream().filter(c -> c.isInicial())
				.collect(Collectors.toList());
	}

	public CanalPagamentoPessoa getCanalContribuicaoRegular() {
		return getContribuicaoRegular() != null ? getContribuicaoRegular()
				.getCanalPagamentoPessoa() : null;
	}

	public CanalPagamentoPessoa getCanalContribuicaoInicial() {
		return getContribuicaoIncial() != null ? getContribuicaoIncial()
				.getCanalPagamentoPessoa() : null;
	}

	private ContaContribuicao getContribuicaoIncial() {
		return contribuicoes.stream().filter(c -> c.isInicial()).findFirst()
				.orElse(null);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaBeneficio) {
			ContaBeneficio other = (ContaBeneficio) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta)
					.append(codPlano, other.codPlano)
					.append(codBeneficio, other.codBeneficio).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.append(codPlano).append(codBeneficio).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).append(codPlano)
				.append(codBeneficio).build();
	}

}
