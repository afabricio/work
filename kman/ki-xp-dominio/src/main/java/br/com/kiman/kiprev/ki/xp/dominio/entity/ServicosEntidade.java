package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.ServicosEntidadePK;

@IdClass(ServicosEntidadePK.class)
@Entity
@Table(name = "SERVICIOS_X_ENTE", schema = "KIPREV")
public class ServicosEntidade {
	
	@Id
	@Column(name = "COD_ENTE")
	private String codEntidade;
	
	@Id
	@Column(name = "COD_SERVICIO")
	private String codServico;
	
	
	@Column(name = "STATUS")
	private String status;


	public String getCodEntidade() {
		return codEntidade;
	}


	public void setCodEntidade(String codEntidade) {
		this.codEntidade = codEntidade;
	}


	public String getCodServico() {
		return codServico;
	}


	public void setCodServico(String codServico) {
		this.codServico = codServico;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
