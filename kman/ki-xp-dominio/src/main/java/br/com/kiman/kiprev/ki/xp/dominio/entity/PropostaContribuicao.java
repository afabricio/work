package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.PropostaContribuicaoPK;

@Entity
@IdClass(PropostaContribuicaoPK.class)
@Table(schema = "KIPREV", name = "AF_CONTRIB_X_SOLIC")
public class PropostaContribuicao {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "NUM_FORMULARIO")
	private Long numFormulario;
	@Id
	@Column(name = "COD_CONTRIB")
	private String codContribuicao;
	@Id
	@Column(name = "PRIMEIRO_APORTE")
	private String primeiroAporte;
	@Column(name = "APORTE_ESPERADO")
	private Double valorAporteEsperado;
	@Column(name = "COD_PRODUTO")
	private String codProduto;
	@Column(name = "COD_PLAN")
	private Long codPlano;
	@Column(name = "COD_BENEFICIO")
	private Long codBeneficio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTRIB", referencedColumnName = "COD_CONTRIB", insertable = false, updatable = false) })
	private Contribuicao contribuicao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PLAN", referencedColumnName = "COD_PLAN", insertable = false, updatable = false),
			@JoinColumn(name = "COD_BENEFICIO", referencedColumnName = "COD_BENEFICIO", insertable = false, updatable = false) })
	private Beneficio beneficio;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false),
			@JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO", insertable = false, updatable = false),
			@JoinColumn(name = "COD_CONTRIB", referencedColumnName = "COD_CONTRIB", insertable = false, updatable = false) })
	private ContribuicaoProduto contribuicaoProduto;

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

	public String getCodContribuicao() {
		return codContribuicao;
	}

	public void setCodContribuicao(String codContribuicao) {
		this.codContribuicao = codContribuicao;
	}

//	public Boolean getPrimeiroAporte() {
//		return BooleanEnum.get(primeiroAporte).getValor();
//	}
//
//	public void setPrimeiroAporte(Boolean primeiroAporte) {
//		this.primeiroAporte = Optional.ofNullable(primeiroAporte)
//				.map(v -> BooleanEnum.get(primeiroAporte).getChave())
//				.orElse(null);
//	}

	public Double getValorAporteEsperado() {
		return Optional.ofNullable(valorAporteEsperado).orElse(0d);
	}

	public void setValorAporteEsperado(Double valorAporteEsperado) {
		this.valorAporteEsperado = valorAporteEsperado;
	}

	public Contribuicao getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(Contribuicao contribuicao) {
		this.contribuicao = contribuicao;
	}

	public ContribuicaoProduto getContribuicaoProduto() {
		return contribuicaoProduto;
	}

	public void setContribuicaoProduto(ContribuicaoProduto contribuicaoProduto) {
		this.contribuicaoProduto = contribuicaoProduto;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropostaContribuicao) {
			PropostaContribuicao other = (PropostaContribuicao) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(numFormulario, other.numFormulario)
					.append(codContribuicao, other.codContribuicao)
					.append(primeiroAporte, other.primeiroAporte).build();
		}
		return false;
	}

	public boolean isRegular() {
		return contribuicao.isRegular();
	}

	public boolean isInicial() {
		return contribuicao.isInicial();
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
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

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(numFormulario)
				.append(codContribuicao).append(primeiroAporte).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(numFormulario)
				.append(codContribuicao).append(primeiroAporte).build();
	}

}
