package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoSexoEnum {

	FEMININO("F", "Feminino"), MASCULINO("M", "Masculino");

	private final String descricao;
	private final String valor;

	private TipoSexoEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoSexoEnum getEnum(String valor) {
		for (TipoSexoEnum tipoEnum : TipoSexoEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
