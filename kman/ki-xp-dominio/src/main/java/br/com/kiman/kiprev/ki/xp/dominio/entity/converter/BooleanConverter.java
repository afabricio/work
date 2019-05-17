package br.com.kiman.kiprev.ki.xp.dominio.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, String> {

	private static final String NAO = "N";
	private static final String SIM = "S";

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return attribute != null && attribute ? SIM : NAO;
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return SIM.equals(dbData);
	}
}
