package br.com.kiman.kiprev.ki.xp.dominio.entity.converter;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.kiman.kiprev.ki.xp.dominio.constants.OpcaoTriutacaoIRRF;

@Converter(autoApply = true)
public class TipoTributacaoConverter implements AttributeConverter<OpcaoTriutacaoIRRF, String> {

	@Override
	public String convertToDatabaseColumn(OpcaoTriutacaoIRRF attribute) {
		return Optional.ofNullable(attribute).map(a -> attribute.getValor()).orElse(null);
	}

	@Override
	public OpcaoTriutacaoIRRF convertToEntityAttribute(String dbData) {
		return OpcaoTriutacaoIRRF.get(dbData);
	}

}
