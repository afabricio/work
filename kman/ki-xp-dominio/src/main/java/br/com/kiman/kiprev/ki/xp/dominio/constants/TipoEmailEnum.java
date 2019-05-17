package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoEmailEnum {

	//@formatter:off
	PESSOAL("PS", "Pessoal"),
	TRABALHO("TR","Trabalho"),
	;
	//@formatter:on

	private final String descricao;
	private final String valor;

	private TipoEmailEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoEmailEnum getEnum(String valor) {
		for (TipoEmailEnum tipoEnum : TipoEmailEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
