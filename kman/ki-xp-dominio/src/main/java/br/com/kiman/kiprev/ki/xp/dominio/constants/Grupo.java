package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum Grupo {
	
	PARAMETRO_FIXO("G_PRM_FIXO");

	private String nome;

	Grupo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
