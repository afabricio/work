package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum OrigemContribuicaoEnum {

	PARTICIPANTE("PTE"), PATROCINADORA("PAT");

	private final String valor;

	private OrigemContribuicaoEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static OrigemContribuicaoEnum getEnum(String valor) {
		for (OrigemContribuicaoEnum tipoEnum : OrigemContribuicaoEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
