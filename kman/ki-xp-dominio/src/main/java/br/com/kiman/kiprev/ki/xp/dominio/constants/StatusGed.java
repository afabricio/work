package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum StatusGed {

	PENDENTE("P"), ERRO("E"), SUCESSO("S");

	private String key;

	private StatusGed(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public static StatusGed getEnum(String key) {
		for (StatusGed status : StatusGed.values()) {
			if (status.key.equals(key)) {
				return status;
			}
		}
		return null;
	}

}
