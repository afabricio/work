package br.com.kiman.kiprev.ki.xp.integration.itau;

public final class Recebimento_divergente {
	public String tipo_autorizacao_recebimento;
	public String tipo_valor_percentual_recebimento;
	public String valor_minimo_recebimento;
	public String percentual_minimo_recebimento;
	public String valor_maximo_recebimento;
	public String percentual_maximo_recebimento;

	public Recebimento_divergente(String tipo_autorizacao_recebimento, String tipo_valor_percentual_recebimento,
			String valor_minimo_recebimento, String percentual_minimo_recebimento, String valor_maximo_recebimento,
			String percentual_maximo_recebimento) {
		this.tipo_autorizacao_recebimento = tipo_autorizacao_recebimento;
		this.tipo_valor_percentual_recebimento = tipo_valor_percentual_recebimento;
		this.valor_minimo_recebimento = valor_minimo_recebimento;
		this.percentual_minimo_recebimento = percentual_minimo_recebimento;
		this.valor_maximo_recebimento = valor_maximo_recebimento;
		this.percentual_maximo_recebimento = percentual_maximo_recebimento;
	}

	public Recebimento_divergente() {
		// TODO Auto-generated constructor stub
	}

	public String getTipo_autorizacao_recebimento() {
		return tipo_autorizacao_recebimento;
	}

	public void setTipo_autorizacao_recebimento(String tipo_autorizacao_recebimento) {
		this.tipo_autorizacao_recebimento = tipo_autorizacao_recebimento;
	}

	public String getTipo_valor_percentual_recebimento() {
		return tipo_valor_percentual_recebimento;
	}

	public void setTipo_valor_percentual_recebimento(String tipo_valor_percentual_recebimento) {
		this.tipo_valor_percentual_recebimento = tipo_valor_percentual_recebimento;
	}

	public String getValor_minimo_recebimento() {
		return valor_minimo_recebimento;
	}

	public void setValor_minimo_recebimento(String valor_minimo_recebimento) {
		this.valor_minimo_recebimento = valor_minimo_recebimento;
	}

	public String getPercentual_minimo_recebimento() {
		return percentual_minimo_recebimento;
	}

	public void setPercentual_minimo_recebimento(String percentual_minimo_recebimento) {
		this.percentual_minimo_recebimento = percentual_minimo_recebimento;
	}

	public String getValor_maximo_recebimento() {
		return valor_maximo_recebimento;
	}

	public void setValor_maximo_recebimento(String valor_maximo_recebimento) {
		this.valor_maximo_recebimento = valor_maximo_recebimento;
	}

	public String getPercentual_maximo_recebimento() {
		return percentual_maximo_recebimento;
	}

	public void setPercentual_maximo_recebimento(String percentual_maximo_recebimento) {
		this.percentual_maximo_recebimento = percentual_maximo_recebimento;
	}

}