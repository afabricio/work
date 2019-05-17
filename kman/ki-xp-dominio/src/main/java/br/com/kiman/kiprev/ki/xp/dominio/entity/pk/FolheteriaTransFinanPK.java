package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INT_033_FOLHETERIA_TRANS_FINAN database table.
 * 
 */
@Embeddable
public class FolheteriaTransFinanPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ENCA", insertable=false, updatable=false)
	private long idEnca;

	@Column(name="ID_DETA", insertable=false, updatable=false)
	private long idDeta;

	@Column(name="ID_TF_DETA")
	private long idTfDeta;

	public FolheteriaTransFinanPK() {
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
	public long getIdTfDeta() {
		return this.idTfDeta;
	}
	public void setIdTfDeta(long idTfDeta) {
		this.idTfDeta = idTfDeta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FolheteriaTransFinanPK)) {
			return false;
		}
		FolheteriaTransFinanPK castOther = (FolheteriaTransFinanPK)other;
		return 
			(this.idEnca == castOther.idEnca)
			&& (this.idDeta == castOther.idDeta)
			&& (this.idTfDeta == castOther.idTfDeta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idEnca ^ (this.idEnca >>> 32)));
		hash = hash * prime + ((int) (this.idDeta ^ (this.idDeta >>> 32)));
		hash = hash * prime + ((int) (this.idTfDeta ^ (this.idTfDeta >>> 32)));
		
		return hash;
	}
}