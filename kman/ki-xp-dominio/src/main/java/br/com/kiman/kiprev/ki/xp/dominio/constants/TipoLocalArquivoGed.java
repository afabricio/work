package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoLocalArquivoGed {

	URL("U"), DIRETORIO("D"), BATCH("B");

	private String key;

	private TipoLocalArquivoGed(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public static TipoLocalArquivoGed getEnum(String valor) {
		for (TipoLocalArquivoGed tipoEnum : TipoLocalArquivoGed.values()) {
			if (tipoEnum.key.equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}
}
