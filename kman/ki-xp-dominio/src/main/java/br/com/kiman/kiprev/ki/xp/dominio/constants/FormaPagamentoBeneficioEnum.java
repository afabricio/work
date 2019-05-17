package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum FormaPagamentoBeneficioEnum {

	UNICO("U", "Único"), RENDA("R", "Renda");

	private final String descricao;
	private final String valor;

	private FormaPagamentoBeneficioEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static FormaPagamentoBeneficioEnum getEnum(String valor) {
		for (FormaPagamentoBeneficioEnum tipoEnum : FormaPagamentoBeneficioEnum
				.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
