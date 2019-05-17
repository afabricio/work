package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAS_JURIDICAS", schema = "KIPREV")
public class PessoaJuridica {

	@Id
	@Column(name = "COD_PER_JURIDICA")
	private String codPessoaJuridica;

	public String getCodPessoaJuridica() {
		return codPessoaJuridica;
	}

	public void setCodPessoaJuridica(String codPessoaJuridica) {
		this.codPessoaJuridica = codPessoaJuridica;
	}


	
	
	
	
	
	
	

}
