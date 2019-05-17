package br.com.kiman.kiprev.ki.xp.dominio.entity.converter;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.kiman.kiprev.ki.xp.dominio.constants.StatusPropostaEnum;

@Converter(autoApply = true)
public class StatusPropostaConverter implements AttributeConverter<StatusPropostaEnum, String> {

	@Override
	public String convertToDatabaseColumn(StatusPropostaEnum attribute) {
		return Optional.ofNullable(attribute).map(a -> attribute.getValor()).orElse(null);
	}

	@Override
	public StatusPropostaEnum convertToEntityAttribute(String dbData) {
		return StatusPropostaEnum.getEnum(dbData);
	}

}
