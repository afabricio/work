package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoEstadoCivilEnum {

	//@formatter:off
	SOLTEIRO("S", "Solteiro"), 
	VIUVO("V", "Viúvo"),
	DIVORCIADO("D", "Divorciado"),
	CASADO("C", "Casado"),
	UNIAO_ESTAVEL("U", "União Estável"),
	OUTROS("O", "Outros"),
	SEPARACAO_BENS("B", "Sep. Bens"),
	DESQUITADO("T", "Desquitado"),
	SEPARADO("P", "Separado"),
	UNIAO_CIVIL("I", "União Civil"),
	AMASIADO("A", "Amasiado"),
	;

	private final String descricao;
	private final String valor;

	private TipoEstadoCivilEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoEstadoCivilEnum getEnum(String valor) {
		for (TipoEstadoCivilEnum tipoEnum : TipoEstadoCivilEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}
}
