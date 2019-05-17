package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.MonitorDetaPK;

@Entity
@IdClass(MonitorDetaPK.class)
@Table(schema = "KIPREV", name = "FO_MONITOR_DETA")
@NamedQueries(value = {@NamedQuery(name  = MonitorDeta.BUSCA_STATUS_MONITOR, query = "SELECT d FROM MonitorDeta d WHERE d.session = :session AND d.codProcesso = :codProcesso AND d.statusFim = :statusFim" )})
public class MonitorDeta {

	public static final String BUSCA_STATUS_MONITOR = "MonitorDeta.buscaStatusMonitor";
	
	@Id
	@Column(name = "SESION")
	private String session;
	@Id
	@Column(name = "COD_SUB_SESION")
	private String codSubSession;
	@Id
	@Column(name = "COD_PROCESSO")
	private String codProcesso;

	@Column(name = "STATUS_FIM")
	private String statusFim;

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

	public String getStatusFim() {
		return statusFim;
	}

	public void setStatusFim(String statusFim) {
		this.statusFim = statusFim;
	}

}
