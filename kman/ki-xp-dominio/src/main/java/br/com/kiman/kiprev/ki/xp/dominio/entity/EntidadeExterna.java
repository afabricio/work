package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoEntidadeExternaEnum;

@Entity
@Table(name = "ENTES_EXTERNOS", schema = "KIPREV")
//@NamedQueries(value = {
//		@NamedQuery(name = JPQLs.N_ENTIDADE_EXTERNA_POR_TIPO, query = JPQLs.Q_ENTIDADE_EXTERNA_POR_TIPO) })
public class EntidadeExterna {

	@Id
	@Column(name = "COD_ENTE")
	private String codigo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_ENTE", referencedColumnName = "TIPO_ENTE")
	private TipoEntidade tipo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ENTE", referencedColumnName = "COD_ENTE")
	private Set<ServicosEntidade> servicos = Sets.newHashSet();;
	
	@Column(name = "TIPO_ENTE", insertable = false, updatable = false)
	private TipoEntidadeExternaEnum tipoEntidadeExterna;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoEntidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntidade tipo) {
		this.tipo = tipo;
	}

	public TipoEntidadeExternaEnum getTipoEntidadeExterna() {
		return tipoEntidadeExterna;
	}

	public void setTipoEntidadeExterna(TipoEntidadeExternaEnum tipoEntidadeExterna) {
		this.tipoEntidadeExterna = tipoEntidadeExterna;
	}

	public Set<ServicosEntidade> getServicos() {
		return servicos;
	}

	public void setServicos(Set<ServicosEntidade> servicos) {
		this.servicos = servicos;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codigo).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EntidadeExterna) {
			EntidadeExterna other = (EntidadeExterna) obj;
			return new EqualsBuilder().append(codigo, other.codigo).build();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(ToStringStyle.DEFAULT_STYLE).append(codigo).build();
	}
}
