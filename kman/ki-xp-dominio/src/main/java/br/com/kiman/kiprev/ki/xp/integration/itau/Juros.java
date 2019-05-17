package br.com.kiman.kiprev.ki.xp.integration.itau;

public class Juros {
	public String data_juros;
	public Short tipo_juros;
	public String valor_juros;
	public String percentual_juros;

	public Juros() {
		// TODO Auto-generated constructor stub
	}

	public Juros(String data_juros, Short tipo_juros, String valor_juros, String percentual_juros) {
		this.data_juros = data_juros;
		this.tipo_juros = tipo_juros;
		this.valor_juros = valor_juros;
		this.percentual_juros = percentual_juros;
	}

	public String getData_juros() {
		return data_juros;
	}

	public Short getTipo_juros() {
		return tipo_juros;
	}

	public String getValor_juros() {
		return valor_juros;
	}

	public String getPercentual_juros() {
		return percentual_juros;
	}

	public void setData_juros(String data_juros) {
		this.data_juros = data_juros;
	}

	public void setTipo_juros(Short tipo_juros) {
		this.tipo_juros = tipo_juros;
	}

	public void setValor_juros(String valor_juros) {
		this.valor_juros = valor_juros;
	}

	public void setPercentual_juros(String percentual_juros) {
		this.percentual_juros = percentual_juros;
	}

}