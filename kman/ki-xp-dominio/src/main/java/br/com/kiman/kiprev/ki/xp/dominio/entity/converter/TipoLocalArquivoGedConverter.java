package br.com.kiman.kiprev.ki.xp.dominio.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.kiman.kiprev.ki.xp.dominio.constants.TipoLocalArquivoGed;

@Converter(autoApply = true)
public class TipoLocalArquivoGedConverter implements AttributeConverter<TipoLocalArquivoGed, String> {

	@Override
	public String convertToDatabaseColumn(TipoLocalArquivoGed attribute) {
		return attribute != null ? attribute.getKey() : null;
	}

	@Override
	public TipoLocalArquivoGed convertToEntityAttribute(String dbData) {
		return TipoLocalArquivoGed.getEnum(dbData);
	}
}