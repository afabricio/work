package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum OpcaoTriutacaoIRRF {

	REGRESSIVA("TR"), PROGRESSIVA("TP");

	private final String valor;

	private OpcaoTriutacaoIRRF(String valor) {
		this.valor = valor;

	}

	public String getValor() {
		return valor;
	}

	public static OpcaoTriutacaoIRRF get(String valor) {
		for (OpcaoTriutacaoIRRF opcaoTriutacao : OpcaoTriutacaoIRRF.values()) {
			if (opcaoTriutacao.getValor().equals(valor)) {
				return opcaoTriutacao;
			}
		}
		return null;
	}

}
