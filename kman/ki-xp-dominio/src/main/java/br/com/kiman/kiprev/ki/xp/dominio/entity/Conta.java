package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.constants.OpcaoTriutacaoIRRF;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoContaEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoMeioPagamento;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaPK;

@Entity
@IdClass(ContaPK.class)
@Table(name = "FO_CUENTAS", schema = "KIPREV")
public class Conta {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Column(name = "NUM_CONTRATO")
	private Long numContrato;
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Column(name = "OPCAO_TRIBUTACAO_IRRF")
	private OpcaoTriutacaoIRRF opcaoTributacaoIRRF;
	@Column(name = "COD_APOLICE")
	private String codApolice;
	@Column(name = "COD_RAMO")
	private Integer codRamo;
	@Column(name = "SEQ_APOLICE_SEGURO")
	private Long seqApolice;
	@Column(name = "EST_CUENTA", insertable = false, updatable = false)
	private String codStatus;

	@Column(name = "FEC_APERTURA")
	private LocalDate dataAbertura;
	@Column(name = "DATA_PREVISTA_GOZO")
	private LocalDate dataFimDiferimento;
	@Column(name = "TIP_CUENTA")
	private TipoContaEnum tipoConta;
	@Column(name = "COD_PRODUCTO")
	private String codProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false) })
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CTA_COLECTIVA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Conta instituidor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_CLIENTE", referencedColumnName = "COD_PERSONA")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA_RESPFIN", referencedColumnName = "COD_PERSONA", insertable = false, updatable = false)
	private Pessoa responsavelFinanceiro;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA"),
			@PrimaryKeyJoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA") })
	private DadosComercial dadosComercial;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<ContaCorretor> corretores = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<ContaTelefone> telefones = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<ContaEndereco> enderecos = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<ContaEmail> emails = Sets.newHashSet();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name = "TIP_STATUS", referencedColumnName = "TIP_STATUS"),
			@JoinColumn(name = "EST_CUENTA", referencedColumnName = "COD_STATUS"),
			@JoinColumn(name = "SUBESTADO", referencedColumnName = "COD_SUB_STATUS") })
	private SubStatus subStatus;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<ContaBeneficio> beneficios = Sets.newHashSet();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Proposta proposta;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<Portabilidade> portabilidades = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "ORIG_COD_CUENTA", referencedColumnName = "COD_CUENTA", insertable = false, updatable = false) })
	private Set<Transferencia> transferencias = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta")
	private Set<ContaReserva> reservas = Sets.newHashSet();

	@Transient
	private Double saldo;
	@Transient
	private LocalDateTime dataSaldo;

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

	public Long getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	public Long getNumFormulario() {
		return numFormulario;
	}

	public void setNumFormulario(Long numFormulario) {
		this.numFormulario = numFormulario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public OpcaoTriutacaoIRRF getOpcaoTributacaoIRRF() {
		return opcaoTributacaoIRRF;
	}

	public void setOpcaoTributacaoIRRF(OpcaoTriutacaoIRRF opcaoTributacaoIRRF) {
		this.opcaoTributacaoIRRF = opcaoTributacaoIRRF;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;

	}

	public String getCodApolice() {
		return codApolice;
	}

	public void setCodApolice(String codApolice) {
		this.codApolice = codApolice;
	}

	public LocalDateTime getDataSaldo() {
		return dataSaldo;
	}

	public void setDataSaldo(LocalDateTime dataSaldo) {
		this.dataSaldo = dataSaldo;
	}

//	public Boolean permiteDetalhamento() {
//		return !(produto.isPRGP() || produto.isVRGP());
//	}

	public boolean hasSaldo() {
		return saldo != null && saldo > 0d;
	}

	public DadosComercial getDadosComercial() {
		return dadosComercial;
	}

	public void setDadosComercial(DadosComercial dadosComercial) {
		this.dadosComercial = dadosComercial;
	}

	public Set<ContaCorretor> getCorretores() {
		return corretores;
	}

	public void setCorretores(Set<ContaCorretor> corretores) {
		this.corretores = corretores;
	}

	public Integer getCodRamo() {
		return codRamo;
	}

	public void setCodRamo(Integer codRamo) {
		this.codRamo = codRamo;
	}

	public Long getSeqApolice() {
		return seqApolice;
	}

	public void setSeqApolice(Long seqApolice) {
		this.seqApolice = seqApolice;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFimDiferimento() {
		return dataFimDiferimento;
	}

	public void setDataFimDiferimento(LocalDate dataFimDiferimento) {
		this.dataFimDiferimento = dataFimDiferimento;
	}

	public Set<ContaEndereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<ContaEndereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getTelefonePrincipal() {
		ContaTelefone telefone = telefones.stream().filter(t -> t.getIndPrincipal() != null && t.getIndPrincipal())
				.findFirst().orElse(null);
		return telefone != null ? telefone.getTelefoneComDDDFormatado() : null;
	}

	public Set<ContaTelefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<ContaTelefone> telefones) {
		this.telefones = telefones;
	}

	public SubStatus getSubStatus() {
		return subStatus;
	}

	public String getEmailPrincipal() {
		ContaEmail email = emails.stream().sorted(Comparator.comparing(ContaEmail::getCodEmail).reversed()).findFirst()
				.orElse(null);

		return email != null ? email.getEmail() : null;
	}

	public void setSubStatus(SubStatus subStatus) {
		this.subStatus = subStatus;
	}

	public Set<ContaEmail> getEmails() {
		return emails;
	}

	public void setEmails(Set<ContaEmail> emails) {
		this.emails = emails;
	}

	public Set<ContaBeneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Set<ContaBeneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public ContaBeneficio getBeneficioSobrevivencia() {
		return beneficios.stream().filter(b -> b.isSobrevivencia()).findFirst().get();
	}

	public ContaContribuicao getContribuicaoRegular() {
		return getBeneficioSobrevivencia().getContribuicaoRegular();
	}

	public boolean hasContribuicaoEsporadica() {
		return getBeneficioSobrevivencia().getContribuicaoEsporadica() != null;
	}

	public ContaContribuicao getContribuicaoEsporadica() {
		return getBeneficioSobrevivencia().getContribuicaoEsporadica();
	}

	public ContaContribuicao getContribuicaoPortabilidade() {
		return getBeneficioSobrevivencia().getContribuicaoPortabilidade();
	}

	public Pessoa getResponsavelFinanceiro() {
		return responsavelFinanceiro;
	}

	public void setResponsavelFinanceiro(Pessoa responsavelFinanceiro) {
		this.responsavelFinanceiro = responsavelFinanceiro;
	}

	public Double getValorContribuicao() {
		return getBeneficioSobrevivencia().getValorContribuicoesRegularesAtivas();
	}

	public Double getValorRisco() {
		return getBeneficiosRisco().stream().flatMap(b -> b.getContribuicoes().stream()).mapToDouble(c -> {
			Double valor = 0d;
			if (c.isAtiva()) {
				valor = c.getValorAporteEsperado();
			}
			return valor;
		}).sum();
	}

	public Double getValorAporteInicial() {
		return getBeneficioSobrevivencia().getValorContribuicoesIniciais();
	}

	public List<ContaBeneficio> getBeneficiosRisco() {
		return getBeneficios().stream().filter(b -> b.isRisco()).collect(Collectors.toList());
	}

	public boolean isContaIndividual() {
		return TipoContaEnum.INDIVIDUAL.equals(tipoConta);
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public Set<ContaReserva> getReservas() {
		return reservas;
	}

	public Set<ContaReserva> getReservasPorCodigo(String codReserva) {

		Set<ContaReserva> set = new HashSet<ContaReserva>();

		for (ContaReserva contaReserva : reservas) {
			if (contaReserva.getCodReserva().equals(codReserva)) {
				set.add(contaReserva);
			}
		}

		return set;
	}

	public void setReservas(Set<ContaReserva> reservas) {
		this.reservas = reservas;
	}

	public List<CanalPagamentoPessoa> getCanaisPagamentoTipo(TipoMeioPagamento tipoMeioPagamento) {
		return pessoa.getCanaisPagamentoTipo(tipoMeioPagamento);
	}

	public CanalPagamentoPessoa getCanalPagamentoPor(TipoMeioPagamento tipoMeioPagamento) {
		return pessoa != null ? pessoa.getCanalDePagamentoPor(tipoMeioPagamento) : null;

	}

	public ContaEndereco getEnderecoPadrao() {
		return enderecos.stream().filter(e -> e.getIndCorrespondencia() != null && e.getIndCorrespondencia())
				.findFirst().orElse(null);
	}

	public String getCodProduto() {
		return codProduto;
	}
//
//	public String getCodOrigem() {
//
//		return ExtratorOrigemPropostaUtil.getCodOrigem(codConta);
//
//	}
//
//	public String getCodProposta() {
//
//		return ExtratorOrigemPropostaUtil.getCodProposta(codConta);
//	}

	public CanalPagamentoPessoa getCanalContribuicaoRegular() {
		ContaBeneficio beneficioSobrevivencia = getBeneficioSobrevivencia();
		return beneficioSobrevivencia != null ? beneficioSobrevivencia.getCanalContribuicaoRegular() : null;
	}

	public CanalPagamentoPessoa getCanalContribuicaoInicial() {
		ContaBeneficio beneficioSobrevivencia = getBeneficioSobrevivencia();
		return beneficioSobrevivencia != null ? beneficioSobrevivencia.getCanalContribuicaoInicial() : null;
	}

	public Set<Portabilidade> getPortabilidades() {
		return portabilidades;
	}

	public Set<Transferencia> getTransferencias() {
		return transferencias;
	}

	public Conta getInstituidor() {
		return instituidor;
	}

	public void setInstituidor(Conta instituidor) {
		this.instituidor = instituidor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Conta) {
			Conta other = (Conta) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa).append(codConta, other.codConta).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append(codEmpresa).append(codConta).build();
	}

}
