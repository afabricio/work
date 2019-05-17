package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoCategoriaReservaEnum {

	BASICA("B", "Básica"), ADICIONAL("A", "Adicional"), OUTROS("O", "Outros");

	private final String valor;
	private final String descricao;

	private TipoCategoriaReservaEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCategoriaReservaEnum getEnum(String valor) {
		for (TipoCategoriaReservaEnum tipoEnum : TipoCategoriaReservaEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}
}
