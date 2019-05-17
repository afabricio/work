package br.com.kiman.kiprev.ki.xp.dominio.service;

import java.util.List;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestLogger;
import br.com.kiman.kiprev.ki.xp.dominio.cliente.rest.ClienteRestService;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.entity.RegistroBoletoItau;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.integration.itau.BeneficiarioEntrada;
import br.com.kiman.kiprev.ki.xp.integration.itau.BoletoItauEntrada;
import br.com.kiman.kiprev.ki.xp.integration.itau.BoletoItauRetorno;
import br.com.kiman.kiprev.ki.xp.integration.itau.Debito;
import br.com.kiman.kiprev.ki.xp.integration.itau.ErroBoletoItauRetorno;
import br.com.kiman.kiprev.ki.xp.integration.itau.Grupo_desconto;
import br.com.kiman.kiprev.ki.xp.integration.itau.Grupo_email_pagador;
import br.com.kiman.kiprev.ki.xp.integration.itau.Juros;
import br.com.kiman.kiprev.ki.xp.integration.itau.MoedaEntrada;
import br.com.kiman.kiprev.ki.xp.integration.itau.Multa;
import br.com.kiman.kiprev.ki.xp.integration.itau.PagadorEntrada;
import br.com.kiman.kiprev.ki.xp.integration.itau.Recebimento_divergente;
import br.com.kiman.kiprev.ki.xp.integration.itau.SucessoBoletoItauRetorno;
import br.com.kiman.kiprev.ki.xp.integration.itau.Token;

@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class GeradorBoletoItauService extends ItauService {

	@Inject
	private ClienteRestService restService;

	public BoletoItauRetorno geraBoletoByBoletoID(Long boletoID) {

		Token token = buscaTokenAutenticacao();

		Response jsonResponse = registraBoletoNoItau(boletoID, token);

		return buildRetorno(jsonResponse);

	}

	private Response registraBoletoNoItau(Long boletoID, Token token) {

		RegistroBoletoItau boletoEntity = dao.find(boletoID, RegistroBoletoItau.class);
		if (boletoEntity == null) {
			
			throw new NegocioException("boleto ID:"+boletoID+" não encontrado!");
		}
		
		
		BoletoItauEntrada boletoEntrada = bindBoletoEntrada(boletoEntity);

		String urlItau = parametroService.buscaParametro(Interface.ENVIO_BOLETO_ONLINE, Grupo.PARAMETRO_FIXO,
				ParametroEnum.URL_ITAU_BOLETO);

		Map<String, Object> map = Maps.newHashMap();

		map.put(HttpHeaders.ACCEPT, "application/vnd.itau");
		map.put("access_token", token.getAccess_token());
		map.put("itau-chave", token.getClientID());
		map.put("identificador", buscaCNPJSeguradora());

		List<?> filtros = Lists
				.newArrayList(new ClienteRestLogger(Interface.ENVIO_BOLETO_ONLINE, boletoEntity.getNum_cobranca()));
		Response jsonResponse = restService.post(urlItau, Entity.json(boletoEntrada), map, filtros);

		return jsonResponse;
	}

	private BoletoItauEntrada bindBoletoEntrada(RegistroBoletoItau boletoEntity) {
		BoletoItauEntrada boletoEntrada = new BoletoItauEntrada();

		BeneficiarioEntrada beneficiario = new BeneficiarioEntrada();
		beneficiario.setAgencia_beneficiario(boletoEntity.getAgencia_beneficiario());
		beneficiario.setConta_beneficiario(boletoEntity.getConta_beneficiario());
		beneficiario.setCpf_cnpj_beneficiario(boletoEntity.getCpf_cnpj_beneficiario());
		beneficiario.setDigito_verificador_conta_beneficiario(boletoEntity.getDig_verificador_conta_benef());
		boletoEntrada.setBeneficiario(beneficiario);

		boletoEntrada.setCodigo_barras(boletoEntity.getCodigo_barras());
		boletoEntrada.setData_emissao(boletoEntity.getData_emissao());
		boletoEntrada.setData_instrucao_1(boletoEntity.getDATA_INSTRUCAO_1());
		boletoEntrada.setData_instrucao_2(boletoEntity.getData_instrucao_2());
		boletoEntrada.setData_instrucao_3(boletoEntity.getData_instrucao_3());
		boletoEntrada.setData_limite_pagamento(boletoEntity.getData_limite_pagamento());
		boletoEntrada.setData_vencimento(boletoEntity.getData_vencimento());

		Debito debito = new Debito();
		debito.setAgencia_debito("");
		debito.setConta_debito("");
		debito.setDigito_verificador_conta_debito("");

		boletoEntrada.setDigito_verificador_nosso_numero(boletoEntity.getDig_verificador_nosso_numero());
		boletoEntrada.setEspecie(boletoEntity.getEspecie());

		Grupo_desconto grupo_desconto = new Grupo_desconto();
		grupo_desconto.setData_desconto(boletoEntity.getData_desconto());
		grupo_desconto.setPercentual_desconto(boletoEntity.getPercentual_desconto());
		grupo_desconto.setTipo_desconto(boletoEntity.getTipo_desconto());
		grupo_desconto.setValor_desconto(boletoEntity.getValor_desconto());
		Grupo_desconto[] arrGrupo_desconto = { grupo_desconto };
		boletoEntrada.setGrupo_desconto(arrGrupo_desconto);

		boletoEntrada.setIdentificador_titulo_empresa(boletoEntity.getIdentificador_titulo_empresa());
		boletoEntrada.setIndicador_pagamento_parcial(boletoEntity.getIndicador_pagamento_parcial());
		boletoEntrada.setInstrucao_cobranca_1(boletoEntity.getInstrucao_cobranca_1());
		boletoEntrada.setInstrucao_cobranca_2(boletoEntity.getInstrucao_cobranca_2());
		boletoEntrada.setInstrucao_cobranca_3(boletoEntity.getInstrucao_cobranca_3());

		Juros juros = new Juros();
		juros.setData_juros(boletoEntity.getData_juros());
		juros.setPercentual_juros(boletoEntity.getPercentual_juros());
		juros.setTipo_juros(boletoEntity.getTipo_juros());
		juros.setValor_juros(boletoEntity.getValor_juros());
		boletoEntrada.setJuros(juros);

		MoedaEntrada moeda = new MoedaEntrada();
		moeda.setCodigo_moeda_cnab(boletoEntity.getCodigo_moeda_cnab());
		moeda.setQuantidade_moeda(boletoEntity.getQuantidade_moeda());
		boletoEntrada.setMoeda(moeda);

		Multa multa = new Multa();
		multa.setData_multa(boletoEntity.getData_multa());
		multa.setPercentual_multa(boletoEntity.getPercentual_multa());
		multa.setTipo_multa(boletoEntity.getTipo_multa());
		multa.setValor_multa(boletoEntity.getValor_multa());
		boletoEntrada.setMulta(multa);

		boletoEntrada.setNosso_numero(boletoEntity.getNosso_numero());

		PagadorEntrada pagador = new PagadorEntrada();
		pagador.setBairro_pagador(boletoEntity.getBairro_pagador());
		pagador.setCep_pagador(boletoEntity.getCep_pagador());
		pagador.setCidade_pagador(boletoEntity.getCidade_pagador());
		pagador.setCpf_cnpj_pagador(boletoEntity.getCpf_cnpj_pagador());
		Grupo_email_pagador emailpagador = new Grupo_email_pagador();
		emailpagador.setEmail_pagador(boletoEntity.getEmail_pagador());
		List<Grupo_email_pagador> arrayGrupoEmailPagador = Lists.newArrayList(emailpagador);

		pagador.setGrupo_email_pagador(arrayGrupoEmailPagador);
		pagador.setLogradouro_pagador(boletoEntity.getLogradouro_pagador());
		pagador.setNome_pagador(boletoEntity.getNome_pagador());
		pagador.setUf_pagador(boletoEntity.getUf_pagador());
		boletoEntrada.setPagador(pagador);

		boletoEntrada.setQuantidade_dias_1(boletoEntity.getQuantidade_dias_1());
		boletoEntrada.setQuantidade_dias_2(boletoEntity.getQuantidade_dias_2());
		boletoEntrada.setQuantidade_dias_3(boletoEntity.getQuantidade_dias_3());
		boletoEntrada.setQuantidade_pagamento_parcial(boletoEntity.getQuantidade_pagamento_parcial());
		boletoEntrada.setQuantidade_parcelas(boletoEntity.getQuantidade_parcelas());

		Recebimento_divergente recebimento_divergente = new Recebimento_divergente();
		recebimento_divergente.setPercentual_maximo_recebimento(boletoEntity.getPercentual_recebimento());
		recebimento_divergente.setPercentual_minimo_recebimento(boletoEntity.getPercentual_minimo_receb());
		recebimento_divergente.setTipo_autorizacao_recebimento(boletoEntity.getTipo_autorizacao_recebimento());
		recebimento_divergente.setTipo_valor_percentual_recebimento(boletoEntity.getTipo_valor_percentual_receb());
		recebimento_divergente.setValor_maximo_recebimento(boletoEntity.getValor_maximo_recebimento());
		recebimento_divergente.setValor_minimo_recebimento(boletoEntity.getValor_minimo_recebimento());
		boletoEntrada.setRecebimento_divergente(recebimento_divergente);

		boletoEntrada.setSeu_numero(boletoEntity.getSeu_numero());
		boletoEntrada.setSubproduto(boletoEntity.getSubproduto());
		boletoEntrada.setTipo_ambiente(boletoEntity.getTipo_ambiente());
		boletoEntrada.setTipo_carteira_titulo(boletoEntity.getTipo_carteira_titulo());
		boletoEntrada.setTipo_cobranca(boletoEntity.getTipo_cobranca());
		boletoEntrada.setTipo_pagamento(boletoEntity.getTipo_pagamento());
		boletoEntrada.setTipo_produto(boletoEntity.getTipo_produto());
		boletoEntrada.setTipo_registro(boletoEntity.getTipo_registro());
		boletoEntrada.setTitulo_aceite(boletoEntity.getTitulo_aceite());
		boletoEntrada.setUso_banco("");
		boletoEntrada.setValor_abatimento(boletoEntity.getValor_abatimento());
		boletoEntrada.setValor_cobrado(boletoEntity.getValor_cobrado());
		return boletoEntrada;
	}

	private BoletoItauRetorno buildRetorno(Response jsonResponse) {
		BoletoItauRetorno retorno = new BoletoItauRetorno();
		retorno.setHttpResponseCode(jsonResponse.getStatus());

		ErroBoletoItauRetorno erro = new ErroBoletoItauRetorno();

		switch (jsonResponse.getStatus()) {
		case 200:

			retorno.setRetornoSucesso(jsonResponse.readEntity(SucessoBoletoItauRetorno.class));
			break;

		case 422:

			retorno.setRetornoErro(jsonResponse.readEntity(ErroBoletoItauRetorno.class));
			break;

		case 400:

			erro.setMensagem("Requisição inválida, conteúdo mal formado.");
			retorno.setRetornoErro(erro);
			break;

		case 401:

			erro.setMensagem("Usuário e senha ou token de acesso são inválidos.");
			retorno.setRetornoErro(erro);
			break;

		case 403:

			erro.setMensagem("O acesso à API está bloqueado ou o usuário está bloqueado.");
			retorno.setRetornoErro(erro);
			break;

		case 404:

			erro.setMensagem("O endereço acessado não existe.");
			retorno.setRetornoErro(erro);
			break;

		case 429:

			erro.setMensagem("O usuário atingiu o limite de requisições.");
			retorno.setRetornoErro(erro);
			break;

		case 500:

			erro.setMensagem("Houve um erro interno do servidor ao processar a requisição.\r\n"
					+ "Este erro pode ter sido causado por entrada mal formatada.\r\n" + "Favor rever o sua entrada.");
			retorno.setRetornoErro(erro);
			break;
		}
		return retorno;
	}

}
