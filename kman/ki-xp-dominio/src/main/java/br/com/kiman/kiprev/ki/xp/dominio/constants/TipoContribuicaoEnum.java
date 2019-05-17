package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoContribuicaoEnum {

	// @formatter:off
	INICIAL("IN", "Inicial"), REGULAR("RE", "Regular"), INICIAL_REGULAR("IR",
			"Inicial + Regular"), ESPORADICA("ES", "Esporadica"), PORTABILIDADE(
			"PR", "Portabilidade"), BENEFICIO_SINISTRO("BS",
			"Beneficios/Sinistros");
	// @formatter:on
	private final String valor;
	private final String descricao;

	private TipoContribuicaoEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoContribuicaoEnum getEnum(String valor) {
		for (TipoContribuicaoEnum tipoEnum : TipoContribuicaoEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

	public boolean isRegular() {
		return this.equals(REGULAR);
	}

	public boolean isEsporadica() {
		return this.equals(ESPORADICA);
	}

	public boolean isPortabilidade() {
		return this.equals(PORTABILIDADE);
	}

	public boolean isInicial() {
		return this.equals(INICIAL);
	}

}
