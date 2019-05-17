package br.com.kiman.kiprev.ki.xp.dominio.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusGed;

@Converter(autoApply = true)
public class StatusGedConverter implements AttributeConverter<StatusGed, String> {

	@Override
	public String convertToDatabaseColumn(StatusGed attribute) {
		return attribute != null ? attribute.getKey() : null;
	}

	@Override
	public StatusGed convertToEntityAttribute(String dbData) {
		return StatusGed.getEnum(dbData);
	}
}