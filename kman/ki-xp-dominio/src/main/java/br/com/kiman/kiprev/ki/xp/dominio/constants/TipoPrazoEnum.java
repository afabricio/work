package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoPrazoEnum {

	VITALICIO("VI", "Vitalício"), PRAZO_CERTO("PC", "Prazo Certo"), TEMPORARIO(
			"TE", "Temporario");

	private final String descricao;
	private final String valor;

	private TipoPrazoEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPrazoEnum getEnum(String valor) {
		for (TipoPrazoEnum tipoEnum : TipoPrazoEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
