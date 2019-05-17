package br.com.kiman.kiprev.ki.xp.dominio.constants;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import br.com.kiman.kiprev.ki.xp.dominio.entity.ParametroInterface;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;

public enum ParametroEnum {
	
	ARQIVO_PEP,
	DIR_ARQIVO_PEP,
	URL_FUNDOS,
	URL_COTAS, 
	URL_INDICES,
	URL_VALOR_INDICE, 
	BASE_DADOS_KIPREV, 
	URL_KIPREV_FORMS,
	URL_UPD_CLIENTES, 
	URL_ITAU_BOLETO, 
	URL_AUTORIZADOR_ITAU, 
	URL_FOLHETERIA, 
	URI_POST_ARQUIVO_GED, 
	URL_REL_GERENCIAL,
	URL_ARRECADACAO_TED;
	
	public String extraiValorParametro(
			List<ParametroInterface> parametrosInterfaces) {
		String valor = Optional.ofNullable(parametrosInterfaces)
				.orElse(Lists.newArrayList()).stream()
				.filter(p -> this.toString().equals(p.getCodParametro())).findFirst()
				.map(p -> p.getValor()).orElse(null);
		if (valor == null) {
			throw new NegocioException(
					"Parametro não encontrado. Verifique se o parâmetro "
							+ this + " foi cadastrado.");
		}
		return valor;
	}

}
