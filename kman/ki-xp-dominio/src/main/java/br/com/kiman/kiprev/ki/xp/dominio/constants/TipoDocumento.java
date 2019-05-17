package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoDocumento {

	CPF("1"), CNPJ("5");

	private final String valor;

	private TipoDocumento(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static TipoDocumento get(String key) {
		for (TipoDocumento t : TipoDocumento.values()) {
			if (t.getValor().equals(key)) {
				return t;
			}
		}
		return null;
	}
}
