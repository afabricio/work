package br.com.kiman.kiprev.ki.xp.dominio.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoContaEnum;

@Converter(autoApply = true)
public class TipoContaConverter implements AttributeConverter<TipoContaEnum, String> {

	@Override
	public String convertToDatabaseColumn(TipoContaEnum attribute) {
		return attribute.getValor();
	}

	@Override
	public TipoContaEnum convertToEntityAttribute(String dbData) {
		return TipoContaEnum.getEnum(dbData);
	}

}
