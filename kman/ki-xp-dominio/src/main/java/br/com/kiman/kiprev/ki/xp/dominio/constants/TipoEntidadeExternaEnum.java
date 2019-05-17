package br.com.kiman.kiprev.ki.xp.dominio.constants;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum TipoEntidadeExternaEnum {

	BANCO("1"),
	ENTIDADE_FECHADA("5");

	private final String valor;

	private TipoEntidadeExternaEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static TipoEntidadeExternaEnum getEnum(String valor) {
		for (TipoEntidadeExternaEnum tipoEnum : TipoEntidadeExternaEnum.values()) {
			if (valor != null
					&& tipoEnum.getValor().equals(valor.toUpperCase())) {
				return tipoEnum;
			}
		}
		return null;
	}

}
