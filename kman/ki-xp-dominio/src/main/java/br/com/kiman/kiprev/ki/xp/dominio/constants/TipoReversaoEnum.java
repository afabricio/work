package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoReversaoEnum {

	//@formatter:off
	SEM_REVERSAO("SR", "Sem reversabilidade"),
	REVERSAO_A_BENEFICIARIO("RB","Com Reversao a um Beneficiario"),
	REVERSAO_AO_CONJUGE_CONTINUIDADE_MENORES("RC", "Com Reversao ao Conjuge Contin. Menores"),
	REVERSAO_AO_CONJUGE("RE", "Com Reversao ao Conjuge"), 
	REVERSAO_AOS_MENORES("RM", "Com Reversao aos Menores");
	
	private final String descricao;
	private final String valor;

	private TipoReversaoEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoReversaoEnum getEnum(String valor) {
		for (TipoReversaoEnum tipoEnum : TipoReversaoEnum.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

}
