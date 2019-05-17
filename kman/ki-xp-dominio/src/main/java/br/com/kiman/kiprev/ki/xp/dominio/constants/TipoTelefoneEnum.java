package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoTelefoneEnum {

	// @formatter:off
	CELULAR("C", "Celular"), TELEFONE("D", "Telefone Direto"), FAX("F", "Fax"), OUTRO(
			"O", "Outro"), PABX("R", "PABX"), TELEFAX("T", "Telefax"), CENTRAL("X", "Central");
	// @formatter:on

	private final String descricao;
	private final String valor;

	private TipoTelefoneEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoTelefoneEnum getEnum(String valor) {
		for (TipoTelefoneEnum tipoEnum : TipoTelefoneEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
