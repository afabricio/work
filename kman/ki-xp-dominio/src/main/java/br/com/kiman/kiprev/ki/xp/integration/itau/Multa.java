package br.com.kiman.kiprev.ki.xp.integration.itau;

public class Multa {
	public String data_multa;
	public Short tipo_multa;
	public String valor_multa;
	public String percentual_multa;

	public Multa(String data_multa, Short tipo_multa, String valor_multa, String percentual_multa) {
		this.data_multa = data_multa;
		this.tipo_multa = tipo_multa;
		this.valor_multa = valor_multa;
		this.percentual_multa = percentual_multa;
	}

	public Multa() {
		// TODO Auto-generated constructor stub
	}

	public String getData_multa() {
		return data_multa;
	}

	public void setData_multa(String data_multa) {
		this.data_multa = data_multa;
	}

	public Short getTipo_multa() {
		return tipo_multa;
	}

	public void setTipo_multa(Short tipo_multa) {
		this.tipo_multa = tipo_multa;
	}

	public String getValor_multa() {
		return valor_multa;
	}

	public void setValor_multa(String valor_multa) {
		this.valor_multa = valor_multa;
	}

	public String getPercentual_multa() {
		return percentual_multa;
	}

	public void setPercentual_multa(String percentual_multa) {
		this.percentual_multa = percentual_multa;
	}

}
