package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoBeneficiarioEnum {

	PARTICIPANTE("A"), BENEFICIARIO("B"), CONTINUIDADE("C"), SUCESSOR_LEGAL("S"), PENSAO_ALIMENTICIA(
			"N");

	private final String valor;

	private TipoBeneficiarioEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static TipoBeneficiarioEnum getEnum(String valor) {
		for (TipoBeneficiarioEnum tipoEnum : TipoBeneficiarioEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
