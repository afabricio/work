package br.com.kiman.kiprev.ki.xp.integration.itau;

public class Debito {
	public String agencia_debito;
	public String conta_debito;
	public String digito_verificador_conta_debito;

	public Debito(String agencia_debito, String conta_debito, String digito_verificador_conta_debito) {
		this.agencia_debito = agencia_debito;
		this.conta_debito = conta_debito;
		this.digito_verificador_conta_debito = digito_verificador_conta_debito;
	}

	public Debito() {
		// TODO Auto-generated constructor stub
	}

	public String getAgencia_debito() {
		return agencia_debito;
	}

	public void setAgencia_debito(String agencia_debito) {
		this.agencia_debito = agencia_debito;
	}

	public String getConta_debito() {
		return conta_debito;
	}

	public void setConta_debito(String conta_debito) {
		this.conta_debito = conta_debito;
	}

	public String getDigito_verificador_conta_debito() {
		return digito_verificador_conta_debito;
	}

	public void setDigito_verificador_conta_debito(String digito_verificador_conta_debito) {
		this.digito_verificador_conta_debito = digito_verificador_conta_debito;
	}

}
