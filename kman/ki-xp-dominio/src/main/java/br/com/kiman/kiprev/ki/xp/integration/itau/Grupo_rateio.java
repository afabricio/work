package br.com.kiman.kiprev.ki.xp.integration.itau;

public  class Grupo_rateio {

	private String agencia_grupo_rateio;
	private String conta_grupo_rateio;
	private String digito_verificador_conta_grupo_rateio;
	private Integer tipo_rateio;
	private String valor_percentual_rateio;

	public Grupo_rateio() {
	}

	public String getAgencia_grupo_rateio() {
		return agencia_grupo_rateio;
	}

	public void setAgencia_grupo_rateio(String agencia_grupo_rateio) {
		this.agencia_grupo_rateio = agencia_grupo_rateio;
	}

	public String getConta_grupo_rateio() {
		return conta_grupo_rateio;
	}

	public void setConta_grupo_rateio(String conta_grupo_rateio) {
		this.conta_grupo_rateio = conta_grupo_rateio;
	}

	public String getDigito_verificador_conta_grupo_rateio() {
		return digito_verificador_conta_grupo_rateio;
	}

	public void setDigito_verificador_conta_grupo_rateio(String digito_verificador_conta_grupo_rateio) {
		this.digito_verificador_conta_grupo_rateio = digito_verificador_conta_grupo_rateio;
	}

	public Integer getTipo_rateio() {
		return tipo_rateio;
	}

	public void setTipo_rateio(Integer tipo_rateio) {
		this.tipo_rateio = tipo_rateio;
	}

	public String getValor_percentual_rateio() {
		return valor_percentual_rateio;
	}

	public void setValor_percentual_rateio(String valor_percentual_rateio) {
		this.valor_percentual_rateio = valor_percentual_rateio;
	}

}