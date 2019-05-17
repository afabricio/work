package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoPessoa {

	PF("PF", "Pessoa Física"), PJ("PJ", "Pessoa Jurídica");

	private final String valor;
	private final String descricao;

	private TipoPessoa(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPessoa get(String key) {
		for (TipoPessoa t : TipoPessoa.values()) {
			if (t.getValor().equals(key)) {
				return t;
			}
		}
		return null;
	}
}
