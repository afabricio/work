package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoLocalizacaoTelefoneEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoTelefoneEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContaTelefonePK;

@Entity
@Table(name = "FO_TEL_CONTA", schema = "KIPREV")
@IdClass(ContaTelefonePK.class)
public class ContaTelefone {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CUENTA")
	private String codConta;
	@Id
	@Column(name = "COD_CLIENTE")
	private String codCliente;
	@Id
	@Column(name = "COD_AREA")
	private String codArea;
	@Id
	@Column(name = "NUM_TELEFONE")
	private String numTelefone;
	@Id
	@Column(name = "TIP_TELEFONE")
	private String tipoTelefone;
	@Id
	@Column(name = "LOCALIZACAO_TEL")
	private String tipoLocalizacaoTelefone;
	@Column(name = "EXTENSAO")
	private Long extensao;
	@Column(name = "OBSERVACAO")
	private String observacao;
	@Column(name = "PADRAO")
	private Boolean indPrincipal;
	@Column(name = "IND_RECEBE_SMS")
	private Boolean indRecebeSMS;

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

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public TipoTelefoneEnum getTipoTelefone() {
		return TipoTelefoneEnum.getEnum(tipoTelefone);
	}

	public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
		this.tipoTelefone = Optional.ofNullable(tipoTelefone)
				.map(a -> a.getValor()).orElse(null);
	}

	public TipoLocalizacaoTelefoneEnum getTipoLocalizacaoTelefone() {
		return TipoLocalizacaoTelefoneEnum.getEnum(tipoLocalizacaoTelefone);
	}

	public void setTipoLocalizacaoTelefone(
			TipoLocalizacaoTelefoneEnum tipoLocalizacaoTelefone) {
		this.tipoLocalizacaoTelefone = Optional
				.ofNullable(tipoLocalizacaoTelefone).map(a -> a.getValor())
				.orElse(null);
	}

	public Long getExtensao() {
		return extensao;
	}

	public void setExtensao(Long extensao) {
		this.extensao = extensao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getIndPrincipal() {
		return indPrincipal;
	}

	public void setIndPrincipal(Boolean indPrincipal) {
		this.indPrincipal = indPrincipal;
	}

	public Boolean getIndRecebeSMS() {
		return indRecebeSMS;
	}

	public void setIndRecebeSMS(Boolean indRecebeSMS) {
		this.indRecebeSMS = indRecebeSMS;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContaTelefone) {
			ContaTelefone other = (ContaTelefone) obj;
			return new EqualsBuilder()
					.append(codEmpresa, other.codEmpresa)
					.append(codConta, other.codConta)
					.append(codCliente, other.codCliente)
					.append(codArea, other.codArea)
					.append(numTelefone, other.numTelefone)
					.append(tipoTelefone, other.tipoTelefone)
					.append(tipoLocalizacaoTelefone,
							other.tipoLocalizacaoTelefone).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codConta)
				.append(codCliente).append(codArea).append(numTelefone)
				.append(tipoTelefone).append(tipoLocalizacaoTelefone).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codConta).append(codCliente)
				.append(codArea).append(numTelefone).append(tipoTelefone)
				.append(tipoLocalizacaoTelefone).build();
	}

	public String getTelefoneComDDDFormatado() {
		return getDDDFormatado() + getNumTelefoneFormatado();
	}

	private String getNumTelefoneFormatado() {
		Pattern RESIDENCIAL = Pattern.compile("(\\d{4})(\\d{4})");
		Pattern CELULAR = Pattern.compile("(\\d{5})(\\d{4})");
		return Optional.ofNullable(numTelefone).map(t -> {
			if (t.length() == 8) {
				return RESIDENCIAL.matcher(numTelefone).replaceAll("$1-$2");
			} else if (t.length() == 9) {
				return CELULAR.matcher(t).replaceAll("$1-$2");
			}
			return t;
		}).orElse("");
	}

	private String getDDDFormatado() {
		return Optional.ofNullable(codArea).map(a -> "(" + a + ")").orElse("");
	}

}
