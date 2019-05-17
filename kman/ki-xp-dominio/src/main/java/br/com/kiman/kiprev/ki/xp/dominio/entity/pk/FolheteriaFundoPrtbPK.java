package br.com.kiman.kiprev.ki.xp.dominio.entity.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INT_033_FOLHETERIA_FUNDO_PRTB database table.
 * 
 */
@Embeddable
public class FolheteriaFundoPrtbPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ENCA", insertable=false, updatable=false)
	private long idEnca;

	@Column(name="ID_DETA", insertable=false, updatable=false)
	private long idDeta;

	@Column(name="ID_PORTAB_DETA", insertable=false, updatable=false)
	private long idPortabDeta;

	@Column(name="ID_FUNDO_PORTAB_DETA")
	private long idFundoPortabDeta;

	public FolheteriaFundoPrtbPK() {
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
	public long getIdPortabDeta() {
		return this.idPortabDeta;
	}
	public void setIdPortabDeta(long idPortabDeta) {
		this.idPortabDeta = idPortabDeta;
	}
	public long getIdFundoPortabDeta() {
		return this.idFundoPortabDeta;
	}
	public void setIdFundoPortabDeta(long idFundoPortabDeta) {
		this.idFundoPortabDeta = idFundoPortabDeta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FolheteriaFundoPrtbPK)) {
			return false;
		}
		FolheteriaFundoPrtbPK castOther = (FolheteriaFundoPrtbPK)other;
		return 
			(this.idEnca == castOther.idEnca)
			&& (this.idDeta == castOther.idDeta)
			&& (this.idPortabDeta == castOther.idPortabDeta)
			&& (this.idFundoPortabDeta == castOther.idFundoPortabDeta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idEnca ^ (this.idEnca >>> 32)));
		hash = hash * prime + ((int) (this.idDeta ^ (this.idDeta >>> 32)));
		hash = hash * prime + ((int) (this.idPortabDeta ^ (this.idPortabDeta >>> 32)));
		hash = hash * prime + ((int) (this.idFundoPortabDeta ^ (this.idFundoPortabDeta >>> 32)));
		
		return hash;
	}
}