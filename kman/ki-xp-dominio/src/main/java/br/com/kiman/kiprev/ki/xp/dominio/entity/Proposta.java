package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusPropostaEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoContaEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PropostaPK;

@Entity
@IdClass(PropostaPK.class)
@Table(name = "AF_ENCA_SOLICITUD", schema = "KIPREV")
public class Proposta {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa = SystemConfEnum.DEFAULT_COMPANY.getValue();
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Column(name = "COD_AGENCIA")
	private String codAgencia = SystemConfEnum.DEFAULT_AGENCY.getValue();
	@Column(name = "IND_PORTABILIDADE_ENTRADA")
	private Boolean indPortabilidadeEntrada;
	@Column(name = "FEC_SOLICITUD")
	private LocalDate dataSolicitacao;
	@Column(name = "tipo_formulario")
	private TipoContaEnum tipoFomulario;
	@Column(name = "DATA_PAGAMENTO_INI")
	private LocalDate dataPagamentoInicial;
	@Column(name = "ESTADO_DB")
	private StatusPropostaEnum status;
	@Column(name = "COD_PRODUCTO")
	private String codProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false) })
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA_RESPFIN", referencedColumnName = "COD_PERSONA")
	private Pessoa responsavelFinanceiro;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Set<PropostaBeneficio> beneficios = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Set<PropostaCorretores> corretores = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Set<PropostaContribuicao> contribuicoes = Sets.newHashSet();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PESSOA_INI", referencedColumnName = "COD_PESSOA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CANAL_INI", referencedColumnName = "COD_CANAL", insertable = false, updatable = false) })
	private CanalPagamentoPessoa canalPagamentoPessoaInicial;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PESSOA_REG", referencedColumnName = "COD_PESSOA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CANAL_REG", referencedColumnName = "COD_CANAL", insertable = false, updatable = false) })
	private CanalPagamentoPessoa canalPagamentoPessoaRegular;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private PropostaDadosBasicos dadosBasicos;

	@Transient
	private Boolean indTransferencia;

	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Set<SolicitacaoPortabilidade> solicPortabilidades = Sets.newHashSet();
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "NUM_FORMULARIO", referencedColumnName = "NUM_FORMULARIO", insertable = false, updatable = false) })
	private Set<SolicitacaoTransferencia> solicTransferencias;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Long getNumFormulario() {
		return numFormulario;
	}

	public void setNumFormulario(Long numFormulario) {
		this.numFormulario = numFormulario;
	}

	public Boolean getIndPortabilidadeEntrada() {
		return indPortabilidadeEntrada;
	}

	public void setIndPortabilidadeEntrada(Boolean indPortabilidadeEntrada) {
		this.indPortabilidadeEntrada = indPortabilidadeEntrada;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

//	public String getCodOrigem() {
//		return ExtratorOrigemPropostaUtil.getCodOrigem(numFormulario);
//	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		this.codProduto = null;
		if (produto != null) {
			this.codProduto = produto.getCodProduto();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getResponsavelFinanceiro() {
		return responsavelFinanceiro;
	}

	public void setResponsavelFinanceiro(Pessoa responsavelFinanceiro) {
		this.responsavelFinanceiro = responsavelFinanceiro;
	}

	public Set<PropostaCorretores> getCorretores() {
		return corretores;
	}

	public void setCorretores(Set<PropostaCorretores> corretores) {
		this.corretores = corretores;
	}

	public Boolean getIndTransferencia() {
		return indTransferencia != null && indTransferencia;
	}

	public void setIndTransferencia(Boolean indTransferencia) {
		this.indTransferencia = indTransferencia;
	}

	public TipoContaEnum getTipoFomulario() {
		return tipoFomulario;
	}

	public void setTipoFomulario(TipoContaEnum tipoFomulario) {
		this.tipoFomulario = tipoFomulario;
	}

	public Set<PropostaBeneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Set<PropostaBeneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public Pessoa getRespnosavelFinanceiro() {
		return responsavelFinanceiro;
	}

	public Set<PropostaContribuicao> getContribuicoes() {
		return contribuicoes;
	}

	public void setContribuicoes(Set<PropostaContribuicao> contribuicoes) {
		this.contribuicoes = contribuicoes;
	}

	public StatusPropostaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusPropostaEnum status) {
		this.status = status;
	}

	public Double getValorContribuicao() {
		return getContribuicoesRenda().stream().filter(c -> c.isRegular()).mapToDouble(c -> c.getValorAporteEsperado())
				.sum();
	}

	public Double getValorRisco() {
		return getContribuicoesRisco().stream().mapToDouble(c -> c.getValorAporteEsperado()).sum();
	}

	public Double getValorAporteInicial() {
		return getContribuicoesRenda().stream().filter(c -> c.isInicial()).mapToDouble(c -> c.getValorAporteEsperado())
				.sum();
	}

	private List<PropostaContribuicao> getContribuicoesRenda() {
		return contribuicoes.stream().filter(c -> c.getBeneficio().isSobrevivencia()).collect(Collectors.toList());
	}

	private List<PropostaContribuicao> getContribuicoesRisco() {
		return contribuicoes.stream().filter(c -> c.getBeneficio().isRisco()).collect(Collectors.toList());
	}

	public Boolean isContaIndividual() {
		return TipoContaEnum.INDIVIDUAL.equals(tipoFomulario);
	}

	public CanalPagamentoPessoa getCanalPagamentoPessoaInicial() {
		return canalPagamentoPessoaInicial;
	}

	public void setCanalPagamentoPessoaInicial(CanalPagamentoPessoa canalPagamentoPessoaInicial) {
		this.canalPagamentoPessoaInicial = canalPagamentoPessoaInicial;
	}

	public CanalPagamentoPessoa getCanalPagamentoPessoaRegular() {
		return canalPagamentoPessoaRegular;
	}

	public void setCanalPagamentoPessoaRegular(CanalPagamentoPessoa canalPagamentoPessoaRegular) {
		this.canalPagamentoPessoaRegular = canalPagamentoPessoaRegular;
	}

	public Set<Reserva> getReservas() {
		return contribuicoes.stream().map(c -> c.getContribuicaoProduto().getReserva()).collect(Collectors.toSet());
	}

	public LocalDate getDataPagamentoInicial() {
		return dataPagamentoInicial;
	}

	public void setDataPagamentoInicial(LocalDate dataPagamentoInicial) {
		this.dataPagamentoInicial = dataPagamentoInicial;
	}

	public PropostaContribuicao addContribuicao(ContribuicaoProduto contribuicao) {
		Beneficio beneficio = Optional.ofNullable(contribuicao.getBeneficio()).orElse(new Beneficio());
		PropostaContribuicao propostaContribuicao = new PropostaContribuicao();
		propostaContribuicao.setCodBeneficio(beneficio.getCodBeneficio());
		propostaContribuicao.setCodEmpresa(beneficio.getCodEmpresa());
		propostaContribuicao.setCodPlano(beneficio.getCodPlano());
		propostaContribuicao.setCodContribuicao(contribuicao.getCodContribuicao());
		propostaContribuicao.setCodProduto(contribuicao.getCodProduto());
		propostaContribuicao.setNumFormulario(numFormulario);
		contribuicoes.add(propostaContribuicao);
		addBeneficio(beneficio);
		return propostaContribuicao;
	}

	public PropostaBeneficio addBeneficio(Beneficio beneficio) {
		PropostaBeneficio propostaBeneficio = beneficios.stream()
				.filter(b -> b.getCodBeneficio().equals(beneficio.getCodBeneficio())
						&& b.getCodPlano().equals(beneficio.getCodPlano()))
				.findFirst().orElse(null);
		if (propostaBeneficio == null) {
			propostaBeneficio = new PropostaBeneficio();
			propostaBeneficio.setBeneficio(beneficio);
			propostaBeneficio.setCodAgencia(SystemConfEnum.DEFAULT_AGENCY.getValue());
			propostaBeneficio.setCodBeneficio(beneficio.getCodBeneficio());
			propostaBeneficio.setCodEmpresa(codEmpresa);
			propostaBeneficio.setCodPlano(beneficio.getCodPlano());
			propostaBeneficio.setCodProduto(Optional.ofNullable(produto).map(p -> p.getCodProduto()).orElse(null));
			propostaBeneficio.setNumFormulario(numFormulario);
			beneficios.add(propostaBeneficio);
		}
		return propostaBeneficio;
	}

	public PropostaCorretores newCorretor(String susepCorretor) {
		PropostaCorretores propostaCorretores = new PropostaCorretores();
		propostaCorretores.setCodEmpresa(codEmpresa);
		propostaCorretores.setNumFormulario(numFormulario);
		propostaCorretores.setCodOficial(susepCorretor);
		corretores.add(propostaCorretores);
		return propostaCorretores;
	}

	public String getCodProduto() {
		return codProduto;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Proposta) {
			Proposta other = (Proposta) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa).append(numFormulario, other.numFormulario)
					.build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append(codEmpresa).append(numFormulario)
				.build();
	}

//	public PropostaDadosBasicos criaDadosBasicos() {
//		dadosBasicos = new PropostaDadosBasicos();
//		dadosBasicos.setNumFormulario(numFormulario);
//		dadosBasicos.setNome(getPessoa().getNome());
//		if (pessoa.isPessoaFisica()) {
//			PessoaFisica pessoaFisica = pessoa.getPessoaFisica();
//			dadosBasicos.setDataNascimento(pessoaFisica.getDataNascimento());
//			dadosBasicos.setTipoSexo(pessoaFisica.getTipoSexo());
//		}
//
//		pessoa.getDocumentos().stream().forEach(d -> {
//			PropostaDocumento documentoProposta = new PropostaDocumento();
//			documentoProposta.setCodDocumento(d.getCodTipoDocumento());
//			documentoProposta.setNumDocumento(d.getNumDocumento());
//			documentoProposta.setNumFormulario(numFormulario);
//			dadosBasicos.getDocumentosProposta().add(documentoProposta);
//		});
//		return dadosBasicos;
//
//	}

	public boolean permiteCancelamento() {
		return isEmPreenchimento() || isPendente() || isValidada() || isErrada();
	}

	private boolean isErrada() {
		return status != null && status.isErrada();
	}

	private boolean isEmPreenchimento() {
		return status != null && status.isEmPreenchimento();
	}

	private boolean isPendente() {
		return status != null && status.isPendente();
	}

	private boolean isValidada() {
		return status != null && status.isValidada();
	}

	public Set<SolicitacaoPortabilidade> getSolicPortabilidades() {
		return solicPortabilidades;
	}

	public Set<SolicitacaoTransferencia> getSolicTransferencias() {
		return solicTransferencias;
	}

}
