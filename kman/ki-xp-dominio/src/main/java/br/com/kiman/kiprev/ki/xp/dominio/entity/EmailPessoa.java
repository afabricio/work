package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import br.com.kiman.kiprev.ki.xp.dominio.entity.pk.EmailPessoaPK;

@Entity
@IdClass(EmailPessoaPK.class)
@Table(name="PA_EMAIL_PESSOA", schema="KIPREV")
public class EmailPessoa {
	
	@Id
	@Column(name="COD_PESSOA")
	private String codigoPessoa;
	@Id
	@Column(name="COD_EMAIL")
	private String codigoEmail;
	@Column(name="TIP_EMAIL")
	private String tipoEmail;
	@Column(name="EMAIL")
	private String email;
	@Column(name="RECEBE_EMAIL")
	private String indRecebeEmail;
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;
	
	public String getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(String codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public String getCodigoEmail() {
		return codigoEmail;
	}
	public void setCodigoEmail(String codigoEmail) {
		this.codigoEmail = codigoEmail;
	}
	public String getTipoEmail() {
		return tipoEmail;
	}
	public void setTipoEmail(String tipoEmail) {
		this.tipoEmail = tipoEmail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndRecebeEmail() {
		return indRecebeEmail;
	}
	public void setIndRecebeEmail(String indRecebeEmail) {
		this.indRecebeEmail = indRecebeEmail;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
}
