package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum StatusPropostaEnum {

	EM_PREENCHIMENTO("GRA"), PENDENTE("PND"), VALIDADA("VAL"), ERRADA("ERR"), CANCELADO("CAN"), RECUSADA("RCH");

	private String valor;

	private StatusPropostaEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static StatusPropostaEnum getEnum(String valor) {
		for (StatusPropostaEnum tipoEnum : StatusPropostaEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

	public boolean isPendente() {
		return this.equals(PENDENTE);
	}

	public boolean isEmPreenchimento() {
		return this.equals(EM_PREENCHIMENTO);
	}

	public boolean isErrada() {
		return this.equals(ERRADA);
	}

	public boolean isValidada() {
		return this.equals(VALIDADA);
	}

}
