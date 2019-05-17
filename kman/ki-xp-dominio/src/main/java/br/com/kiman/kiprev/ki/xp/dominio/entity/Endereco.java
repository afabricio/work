package br.com.kiman.kiprev.ki.xp.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(schema = "KIPREV", name = "V_PA_ENDERECO")
public class Endereco {

	@Id
	@Column(name = "COD_ENDERECO")
	private String codEndereco;
	@Column(name = "CEP")
	private String CEP;
	@Column(name = "TIP_LOGRADOURO")
	private String tipoLogradouro;
	@Column(name = "LOGRADOURO")
	private String logradouro;
	@Column(name = "NUMERO")
	private String numero;
	@Column(name = "COMPLEMENTO")
	private String complemento;
	@Column(name = "BAIRRO")
	private String bairro;
	@Column(name = "COD_CIDADE")
	private String codCidade;
	@Column(name = "CIDADE")
	private String cidade;
	@Column(name = "UF")
	private String UF;
	@Column(name = "COD_PAIS")
	private String codPAis;
	@Column(name = "PAIS")
	private String pais;

	public String getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(String codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(String codCidade) {
		this.codCidade = codCidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getCodPAis() {
		return codPAis;
	}

	public void setCodPAis(String codPAis) {
		this.codPAis = codPAis;
	}

	public String getPais() {
		
		
		
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean comparaEndereco(String cep, String logradouro,
			String numero, String bairro) {
		String padrao = "%s%s%s%s";
		String enderecoPadrao = String.format(padrao, this.getCEP(),
				this.getLogradouro(), this.getNumero(), this.getBairro());
		String endereco = String
				.format(padrao, cep, logradouro, numero, bairro);
		return enderecoPadrao.equalsIgnoreCase(endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Endereco) {
			Endereco other = (Endereco) obj;
			return new EqualsBuilder().append(codEndereco, other.codEndereco)
					.build();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(codEndereco).build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append(
				codEndereco).build();
	}
	
	
	
	public static void main(String[] args) {
		

		Double d = 1500.93232112;
		long e = Math.round(d * 100.00);
			
		//Integer i = d * 
		
		System.err.println(e);
	}

}
