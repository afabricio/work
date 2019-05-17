package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum BatchResult {
	SUCESSO("T"), FINALIZADO_COM_ERRO("E"), ABORTADO("A"), EMPROCESSAMENTO("P");

	private String value;

	private BatchResult(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static BatchResult fromValue(String value) {

		for (BatchResult batchResult : BatchResult.values()) {
			if (value.equals(batchResult.getValue())) {
				return batchResult;
			}
		}
		return null;
	}

}
