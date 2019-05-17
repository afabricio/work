package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.constants.OrigemContribuicaoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusContribuicaoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoContribuicaoEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ContribuicaoPK;

@Entity
@IdClass(ContribuicaoPK.class)
@Table(schema = "KIPREV", name = "FO_CONTRIBUICOES")
public class Contribuicao {

	@Id
	@Column(name = "COD_EMPRESA")
	private String codEmpresa;
	@Id
	@Column(name = "COD_CONTRIB")
	private String codContribuicao;
	@Column(name = "NOM_CONTRIB")
	private String descricao;
	@Column(name = "STATUS")
	private StatusContribuicaoEnum status;
	@Column(name = "ORIGEM_CONTRIB")
	private OrigemContribuicaoEnum origemContribuicao;
	@Column(name = "TIP_CONTRIB")
	private TipoContribuicaoEnum tipoContribuicao;

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getCodContribuicao() {
		return codContribuicao;
	}

	public void setCodContribuicao(String codContribuicao) {
		this.codContribuicao = codContribuicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusContribuicaoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusContribuicaoEnum status) {
		this.status = status;
	}

	public OrigemContribuicaoEnum getOrigemContribuicao() {
		return origemContribuicao;
	}

	public void setOrigemContribuicao(OrigemContribuicaoEnum origemContribuicao) {
		this.origemContribuicao = origemContribuicao;
	}

	public TipoContribuicaoEnum getTipoContribuicao() {
		return tipoContribuicao;
	}

	public void setTipoContribuicao(TipoContribuicaoEnum tipoContribuicao) {
		this.tipoContribuicao = tipoContribuicao;
	}

	public boolean isRegular() {
		return tipoContribuicao.isRegular();
	}

	public boolean isEsporadica() {
		return tipoContribuicao.isEsporadica();
	}

	public boolean isPortabilidade() {
		return tipoContribuicao.isPortabilidade();
	}

	public boolean isInicial() {
		return tipoContribuicao.isInicial();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contribuicao) {
			Contribuicao other = (Contribuicao) obj;
			return new EqualsBuilder().append(codEmpresa, other.codEmpresa)
					.append(codContribuicao, other.codContribuicao).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEmpresa).append(codContribuicao)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append(codEmpresa).append(codContribuicao).build();
	}

}
