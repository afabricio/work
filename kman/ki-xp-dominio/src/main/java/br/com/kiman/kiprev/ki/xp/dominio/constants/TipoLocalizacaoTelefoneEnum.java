package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoLocalizacaoTelefoneEnum {

	//@formatter:off
	CASA("C", "Casa"),
	OUTROS("O", "Outros"),
	TRABALHO("T", "Trabalho")
	;
	//@formatter:on

	private final String descricao;
	private final String valor;

	private TipoLocalizacaoTelefoneEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoLocalizacaoTelefoneEnum getEnum(String valor) {
		for (TipoLocalizacaoTelefoneEnum tipoEnum : TipoLocalizacaoTelefoneEnum
				.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
