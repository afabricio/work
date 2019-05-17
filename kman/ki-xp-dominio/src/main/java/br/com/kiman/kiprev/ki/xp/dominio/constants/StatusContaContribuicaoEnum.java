package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum StatusContaContribuicaoEnum {

	ATIVO("AC"), INATIVO("IN"), SUSPENSA("SU"), MANUTENCAO("MA"), MANUTENCAO_SUSPENSA_INATIVA(
			"MS");

	private final String valor;

	private StatusContaContribuicaoEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static StatusContaContribuicaoEnum getEnum(String valor) {
		for (StatusContaContribuicaoEnum tipoEnum : StatusContaContribuicaoEnum
				.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}
}
