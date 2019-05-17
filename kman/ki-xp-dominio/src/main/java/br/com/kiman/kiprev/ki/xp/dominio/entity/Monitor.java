package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.MonitorPK;

@Entity
@IdClass(MonitorPK.class)
@Table(schema = "KIPREV", name = "FO_MONITOR")
@NamedQueries(value = {
		@NamedQuery(name = Monitor.BUSCA_STATUS_MONITOR, query = "SELECT d FROM Monitor d WHERE d.session = :session AND d.codProcesso = :codProcesso") })
public class Monitor {

	public static final String BUSCA_STATUS_MONITOR = "Monitor.buscaStatusMonitor";

	@Id
	@Column(name = "SESION")
	private String session;
	@Id
	@Column(name = "COD_SUB_SESION")
	private String codSubSession;
	@Id
	@Column(name = "COD_PROCESSO")
	private String codProcesso;

	@Column(name = "ESTADO")
	private String status;

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getCodSubSession() {
		return codSubSession;
	}

	public void setCodSubSession(String codSubSession) {
		this.codSubSession = codSubSession;
	}

	public String getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(String codProcesso) {
		this.codProcesso = codProcesso;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
