package br.com.kiman.kiprev.ki.xp.integration.itau;

public final class Grupo_desconto {
	public String data_desconto;
	public Short tipo_desconto;
	public String valor_desconto;
	public String percentual_desconto;

	public Grupo_desconto(String data_desconto, Short tipo_desconto, String valor_desconto,
			String percentual_desconto) {
		this.data_desconto = data_desconto;
		this.tipo_desconto = tipo_desconto;
		this.valor_desconto = valor_desconto;
		this.percentual_desconto = percentual_desconto;
	}

	public Grupo_desconto() {
		// TODO Auto-generated constructor stub
	}

	public String getData_desconto() {
		return data_desconto;
	}

	public void setData_desconto(String data_desconto) {
		this.data_desconto = data_desconto;
	}

	public Short getTipo_desconto() {
		return tipo_desconto;
	}

	public void setTipo_desconto(Short tipo_desconto) {
		this.tipo_desconto = tipo_desconto;
	}

	public String getValor_desconto() {
		return valor_desconto;
	}

	public void setValor_desconto(String valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	public String getPercentual_desconto() {
		return percentual_desconto;
	}

	public void setPercentual_desconto(String percentual_desconto) {
		this.percentual_desconto = percentual_desconto;
	}

}