package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.time.LocalDate;
import java.util.Set;

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
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ProdutoPK;

@IdClass(ProdutoPK.class)
@Entity
@Table(schema = "KIPREV", name = "FO_PRODUCTOS")
//@NamedQueries(value = {
//		@NamedQuery(name = N_PRODUTOS_INDIVIDUAIS, query = Q_PRODUTOS_INDIVIDUAIS),
//		@NamedQuery(name = N_PRODUTOS_ATIVOS, query = Q_PRODUTOS_ATIVOS) })
public class Produto {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_PRODUCTO")
	private String codProduto;
	@Column(name = "DESCRIPCION")
	private String descricao;
	@Column(name = "COD_GRUPO")
	private Long codGrupo;
//	@Convert(converter = TipoProdutoConverter.class)
//	@Column(name = "TIP_PESSOA")
//	private TipoPessoa tipo;
	@Column(name = "COD_CAT_PRODUTO", insertable = false, updatable = false)
	private String codCategoria;
	@Column(name = "COD_SUBCAT_PRODUTO", insertable = false, updatable = false)
	private String codSubCategoria;
	@Column(name = "IND_BENEFICIARIO")
	private String indBeneficiario;
	@Column(name = "COD_RAMO")
	private Integer codRamo;
	@Column(name = "DATA_INI_VALIDADE")
	private LocalDate dataInicioVigencia;
	@Column(name = "DATA_FIM_VALIDADE")
	private LocalDate dataFimVigencia;
	
	@Column(name = "IND_EDUCAR")
	private String flagInfantil;

	@Transient
	private ProdutoGerencial produtoGerencial;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_CAT_PRODUTO", referencedColumnName = "COD_CAT_PRODUCTO"),
			@JoinColumn(name = "COD_SUBCAT_PRODUTO", referencedColumnName = "COD_SUBCAT_PRODUCTO") })
	private SubCategoriaProduto subCategoriaProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_RAMO", referencedColumnName = "COD_RAMO", insertable = false, updatable = false) })
	private RamoSeguro ramo;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false) })
	private Set<ProdutoBeneficio> produtoBeneficios = Sets.newHashSet();

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUCTO", insertable = false, updatable = false) })
	private Set<ContribuicaoProduto> produtoContribuicoes = Sets.newHashSet();

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Long codGrupo) {
		this.codGrupo = codGrupo;
	}

//	public TipoPessoa getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(TipoPessoa tipo) {
//		this.tipo = tipo;
//	}

	public SubCategoriaProduto getSubCategoriaProduto() {
		return subCategoriaProduto;
	}

	public void setSubCategoriaProduto(SubCategoriaProduto subCategoriaProduto) {
		this.subCategoriaProduto = subCategoriaProduto;
	}

	public Integer getCodRamo() {
		return codRamo;
	}

	public void setCodRamo(Integer codRamo) {
		this.codRamo = codRamo;
	}

	public RamoSeguro getRamo() {
		return ramo;
	}

	public void setRamo(RamoSeguro ramo) {
		this.ramo = ramo;
	}

	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

//	private boolean isFO() {
//		return Sistema.FO.getValor().equals(codCategoria);
//	}

//	public boolean isPRGP() {
//		return isFO() && "02".equals(codSubCategoria);
//	}

//	public boolean isVRGP() {
//		return isFO() && "06".equals(codSubCategoria);
//	}

	public ProdutoGerencial getProdutoGerencial() {
		return produtoGerencial;
	}

	public void setProdutoGerencial(ProdutoGerencial produtoGerencial) {
		this.produtoGerencial = produtoGerencial;
	}

//	public void setIndBeneficiario(String indBeneficiario) {
//		this.indBeneficiario = indBeneficiario;
//		if (indBeneficiario != null
//				&& (!isBeneficiarioPorCertificado() || !isBeneficiarioPorBeneficio())) {
//			indBeneficiario = null;
//			throw new ValidacaoException(
//					"Valor inválido para a parametrização do beneficiário. ");
//		}
//	}

	public Set<ContribuicaoProduto> getProdutoContribuicoes() {
		return produtoContribuicoes;
	}

	public void setProdutoContribuicoes(
			Set<ContribuicaoProduto> produtoContribuicoes) {
		this.produtoContribuicoes = produtoContribuicoes;
	}

	public boolean isBeneficiarioPorBeneficio() {
		return "B".equals(indBeneficiario);
	}

	public boolean isBeneficiarioPorCertificado() {
		return "C".equals(indBeneficiario);
	}

	public ProdutoBeneficio getBeneficioSobrevivencia() {
		return produtoBeneficios.stream()
				.filter(b -> b.isBeneficioSobrevivencia()).findFirst()
				.orElse(null);
	}

	public ContribuicaoProduto getContribuicaoRegularRenda() {
		return produtoContribuicoes.stream()
				.filter(c -> c.isRegular() && c.isSobrevivencia()).findFirst()
				.orElse(null);
	}

	public ContribuicaoProduto getContribuicaoInicialRenda() {
		return produtoContribuicoes.stream()
				.filter(c -> c.isInicial() && c.isSobrevivencia()).findFirst()
				.orElse(null);
	}

	
	
	
	public String getFlagInfantil() {
		return flagInfantil;
	}

	public void setFlagInfantil(String flagInfantil) {
		this.flagInfantil = flagInfantil;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Produto) {
			Produto p = (Produto) obj;
			return new EqualsBuilder().append(codEmpresa, p.codEmpresa)
					.append(codProduto, p.codProduto).isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codProduto)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(codEmpresa).append(codProduto).build();
	}
}
