package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoOrigemReservaEnum {

	PARTICIPANTE("PE", "Pessoal"), EMPRESA("PR", "Instituidora");

	private final String valor;
	private final String descricao;

	private TipoOrigemReservaEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoOrigemReservaEnum getEnum(String valor) {
		for (TipoOrigemReservaEnum tipoEnum : TipoOrigemReservaEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

	public boolean isEmpresa() {
		return EMPRESA.equals(this);
	}
}
