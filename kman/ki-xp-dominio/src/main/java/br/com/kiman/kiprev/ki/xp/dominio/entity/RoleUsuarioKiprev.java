package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.RoleUsuarioPK;

@Entity
@IdClass(RoleUsuarioPK.class)
@Table(name = "USUARIOS_X_ROLES", schema = "KIPREV")
@Cacheable(false)
public class RoleUsuarioKiprev {

	@Id
	@Column(name = "COD_ROL")
	private String codRole;
	@Id
	@Column(name = "COD_USUARIO")
	private String codUsuario;

	public String getCodRole() {
		return codRole;
	}

	public void setCodRole(String codRole) {
		this.codRole = codRole;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RoleUsuarioKiprev) {
			RoleUsuarioKiprev other = (RoleUsuarioKiprev) obj;
			return new EqualsBuilder().append(codRole, other.codRole)
					.append(codUsuario, other.codUsuario).build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codRole).append(codUsuario).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("codRole", codRole).append("codUsuario", codUsuario)
				.build();
	}
}
