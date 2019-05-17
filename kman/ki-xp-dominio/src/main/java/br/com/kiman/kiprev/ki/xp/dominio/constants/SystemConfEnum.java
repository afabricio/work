package br.com.kiman.kiprev.ki.xp.dominio.constants;

import br.com.kiman.kiprev.ki.xp.dominio.util.PropertiesUtil;

public enum SystemConfEnum {

	DEFAULT_COMPANY("defaultCompany"),

	DEFAULT_AGENCY("defaultAgency"),

	DEFAULT_LANGUAGE("defaultLanguage"),

	CPF_DOCUMENT_TYPE("kiprev.TIP_DOCTO_CPF"),

	CNPJ_DOCUMENT_TYPE("kiprev.TIP_DOCTO_CNPJ"),

	PATTERN_DATE("dd/MM/yyyy");
	
	private String value;
	private String key;

	private SystemConfEnum(String key) {
		this.key = key;
		this.value = PropertiesUtil.getProperty(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
