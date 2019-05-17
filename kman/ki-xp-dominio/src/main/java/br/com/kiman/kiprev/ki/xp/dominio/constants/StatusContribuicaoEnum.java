package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum StatusContribuicaoEnum {

	ATIVO("A"), INATIVO("I");

	private final String valor;

	private StatusContribuicaoEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static StatusContribuicaoEnum getEnum(String valor) {
		for (StatusContribuicaoEnum tipoEnum : StatusContribuicaoEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}
}
