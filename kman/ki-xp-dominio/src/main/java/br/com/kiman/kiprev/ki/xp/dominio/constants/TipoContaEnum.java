package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoContaEnum {

	INDIVIDUAL("I", "Individual"), EMPRESARIAL("C", "Empresarial");

	private final String valor;
	private final String descricao;

	private TipoContaEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoContaEnum getEnum(String valor) {
		for (TipoContaEnum tipo : TipoContaEnum.values()) {
			if (tipo.getValor().equals(valor)) {
				return tipo;
			}
		}
		return null;
	}

}
