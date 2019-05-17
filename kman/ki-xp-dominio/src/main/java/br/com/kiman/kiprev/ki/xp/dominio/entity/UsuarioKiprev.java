package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Sets;

@Entity
@Table(schema = "KIPREV", name = "USUARIOS")
public class UsuarioKiprev {

	@Id
	@Column(name = "COD_USUARIO")
	private String codUsuario;
	@Column(name = "EST_ACTIVO")
	private Boolean indAtivo;
	@Column(name = "TOKEN_LOGIN_EXT")
	private String token;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
	private Set<RoleUsuarioKiprev> roles = Sets.newHashSet();

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public Boolean getIndAtivo() {
		return indAtivo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setIndAtivo(Boolean indAtivo) {
		this.indAtivo = indAtivo;
	}

	public Set<RoleUsuarioKiprev> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleUsuarioKiprev> roles) {
		this.roles = roles;
	}

	public boolean isInativo() {
		return getIndAtivo() != null && !getIndAtivo();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UsuarioKiprev) {
			UsuarioKiprev other = (UsuarioKiprev) obj;
			return new EqualsBuilder().append(codUsuario, other.codUsuario).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codUsuario).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("codUsuario", codUsuario).build();
	}

}
