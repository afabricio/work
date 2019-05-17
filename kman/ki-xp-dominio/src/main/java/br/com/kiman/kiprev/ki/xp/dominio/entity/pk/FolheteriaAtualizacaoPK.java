package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INT_033_FOLHETERIA_ATUALIZACAO database table.
 * 
 */
@Embeddable
public class FolheteriaAtualizacaoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ENCA", insertable=false, updatable=false)
	private long idEnca;

	@Column(name="ID_DETA", insertable=false, updatable=false)
	private long idDeta;

	@Column(name="ID_ATUALIZACAO_DETA")
	private long idAtualizacaoDeta;

	public FolheteriaAtualizacaoPK() {
	}
	public long getIdEnca() {
		return this.idEnca;
	}
	public void setIdEnca(long idEnca) {
		this.idEnca = idEnca;
	}
	public long getIdDeta() {
		return this.idDeta;
	}
	public void setIdDeta(long idDeta) {
		this.idDeta = idDeta;
	}
	public long getIdAtualizacaoDeta() {
		return this.idAtualizacaoDeta;
	}
	public void setIdAtualizacaoDeta(long idAtualizacaoDeta) {
		this.idAtualizacaoDeta = idAtualizacaoDeta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FolheteriaAtualizacaoPK)) {
			return false;
		}
		FolheteriaAtualizacaoPK castOther = (FolheteriaAtualizacaoPK)other;
		return 
			(this.idEnca == castOther.idEnca)
			&& (this.idDeta == castOther.idDeta)
			&& (this.idAtualizacaoDeta == castOther.idAtualizacaoDeta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idEnca ^ (this.idEnca >>> 32)));
		hash = hash * prime + ((int) (this.idDeta ^ (this.idDeta >>> 32)));
		hash = hash * prime + ((int) (this.idAtualizacaoDeta ^ (this.idAtualizacaoDeta >>> 32)));
		
		return hash;
	}
}