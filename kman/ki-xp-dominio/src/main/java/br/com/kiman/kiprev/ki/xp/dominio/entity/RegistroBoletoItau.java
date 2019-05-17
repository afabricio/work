package br.com.kiman.kiprev.ki.xp.dominio.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.kiman.kiprev.ki.xp.dominio.util.XPUtil;

@Entity
@Table(schema = "kpvcust11", name = "int_025_registro_online")
public class RegistroBoletoItau {
	


	@Id
	@Column(name = "ID_REGISTRO_ONLINE")
	Long id_registro_online;
	@Column(name = "NUM_COBRANCA")
	String num_cobranca;
	@Column(name = "COD_CUENTA")
	String cod_cuenta;
	@Column(name = "TIPO_AMBIENTE")
	Short tipo_ambiente;
	@Column(name = "TIPO_REGISTRO")
	Short tipo_registro;
	@Column(name = "TIPO_COBRANCA")
	Short tipo_cobranca;
	@Column(name = "TIPO_PRODUTO")
	String tipo_produto;
	@Column(name = "SUBPRODUTO")
	String subproduto;
	@Column(name = "IDENTIFICADOR_TITULO_EMPRESA")
	String identificador_titulo_empresa;
	@Column(name = "TITULO_ACEITE")
	String titulo_aceite;
	@Column(name = "TIPO_CARTEIRA_TITULO")
	String tipo_carteira_titulo;
	@Column(name = "NOSSO_NUMERO")
	String nosso_numero;
	@Column(name = "DIG_VERIFICADOR_NOSSO_NUMERO")
	String dig_verificador_nosso_numero;
	@Column(name = "CODIGO_BARRAS")
	String codigo_barras;
	@Column(name = "DATA_VENCIMENTO")
	Date data_vencimento;
	@Column(name = "VALOR_COBRADO")
	Double valor_cobrado;
	@Column(name = "SEU_NUMERO")
	String seu_numero;
	@Column(name = "ESPECIE")
	String especie;
	@Column(name = "DATA_EMISSAO")
	Date data_emissao;
	@Column(name = "DATA_LIMITE_PAGAMENTO")
	Date data_limite_pagamento;
	@Column(name = "TIPO_PAGAMENTO")
	Short tipo_pagamento;
	@Column(name = "INDICADOR_PAGAMENTO_PARCIAL")
	Boolean indicador_pagamento_parcial;
	@Column(name = "QUANTIDADE_PAGAMENTO_PARCIAL")
	Short quantidade_pagamento_parcial;
	@Column(name = "QUANTIDADE_PARCELAS")
	Short quantidade_parcelas;
	@Column(name = "INSTRUCAO_COBRANCA_1")
	String instrucao_cobranca_1;
	@Column(name = "QUANTIDADE_DIAS_1")
	Short quantidade_dias_1;
	@Column(name = "DATA_INSTRUCAO_1")
	Date DATA_INSTRUCAO_1;
	@Column(name = "INSTRUCAO_COBRANCA_2")
	String instrucao_cobranca_2;
	@Column(name = "QUANTIDADE_DIAS_2")
	Short quantidade_dias_2;
	@Column(name = "DATA_INSTRUCAO_2")
	Date data_instrucao_2;
	@Column(name = "INSTRUCAO_COBRANCA_3")
	String instrucao_cobranca_3;
	@Column(name = "QUANTIDADE_DIAS_3")
	Short quantidade_dias_3;
	@Column(name = "DATA_INSTRUCAO_3")
	Date data_instrucao_3;
	@Column(name = "VALOR_ABATIMENTO")
	Double valor_abatimento;
	@Column(name = "CPF_CNPJ_BENEFICIARIO")
	String cpf_cnpj_beneficiario;
	@Column(name = "AGENCIA_BENEFICIARIO")
	String agencia_beneficiario;
	@Column(name = "CONTA_BENEFICIARIO")
	String conta_beneficiario;
	@Column(name = "DIG_VERIFICADOR_CONTA_BENEF")
	String dig_verificador_conta_benef;
	@Column(name = "CPF_CNPJ_PAGADOR")
	String cpf_cnpj_pagador;
	@Column(name = "NOME_PAGADOR")
	String nome_pagador;
	@Column(name = "LOGRADOURO_PAGADOR")
	String logradouro_pagador;
	@Column(name = "BAIRRO_PAGADOR")
	String bairro_pagador;
	@Column(name = "CIDADE_PAGADOR")
	String cidade_pagador;
	@Column(name = "UF_PAGADOR")
	String uf_pagador;
	@Column(name = "CEP_PAGADOR")
	String cep_pagador;
	@Column(name = "EMAIL_PAGADOR")
	String email_pagador;
	@Column(name = "CPF_CNPJ_SACADOR_AVALISTA")
	String cpf_cnpj_sacador_avalista;
	@Column(name = "NOME_SACADOR_AVALISTA")
	String nome_sacador_avalista;
	@Column(name = "LOGRADOURO_SACADOR_AVALISTA")
	String logradouro_sacador_avalista;
	@Column(name = "BAIRRO_SACADOR_AVALISTA")
	String bairro_sacador_avalista;
	@Column(name = "CIDADE_SACADOR_AVALISTA")
	String cidade_sacador_avalista;
	@Column(name = "UF_SACADOR_AVALISTA")
	String uf_sacador_avalista;
	@Column(name = "CEP_SACADOR_AVALISTA")
	String cep_sacador_avalista;
	@Column(name = "CODIGO_MOEDA_CNAB")
	String codigo_moeda_cnab;
	@Column(name = "QUANTIDADE_MOEDA")
	Double quantidade_moeda;
	@Column(name = "DATA_JUROS")
	Date data_juros;
	@Column(name = "TIPO_JUROS")
	Short tipo_juros;
	@Column(name = "VALOR_JUROS")
	Double valor_juros;
	@Column(name = "PERCENTUAL_JUROS")
	Double percentual_juros;
	@Column(name = "DATA_MULTA")
	Date data_multa;
	@Column(name = "TIPO_MULTA")
	Short tipo_multa;
	@Column(name = "VALOR_MULTA")
	Double valor_multa;
	@Column(name = "PERCENTUAL_MULTA")
	Double percentual_multa;
	@Column(name = "DATA_DESCONTO")
	Date data_desconto;
	@Column(name = "TIPO_DESCONTO")
	Short tipo_desconto;
	@Column(name = "VALOR_DESCONTO")
	Double valor_desconto;
	@Column(name = "PERCENTUAL_DESCONTO")
	Double percentual_desconto;
	@Column(name = "TIPO_AUTORIZACAO_RECEBIMENTO")
	String tipo_autorizacao_recebimento;
	@Column(name = "TIPO_VALOR_PERCENTUAL_RECEB")
	String tipo_valor_percentual_receb;
	@Column(name = "VALOR_MINIMO_RECEBIMENTO")
	Double valor_minimo_recebimento;
	@Column(name = "PERCENTUAL_MINIMO_RECEB")
	Double percentual_minimo_receb;
	@Column(name = "VALOR_MAXIMO_RECEBIMENTO")
	Double valor_maximo_recebimento;
	@Column(name = "PERCENTUAL_RECEBIMENTO")
	Double percentual_recebimento;
	@Column(name = "AGENCIA_GRUPO_RATEIO")
	String agencia_grupo_rateio;
	@Column(name = "CONTA_GRUPO_RATEIO")
	String conta_grupo_rateio;
	@Column(name = "DIG_VERIF_CONTA_GRUPO_RATEIO")
	String dig_verif_conta_grupo_rateio;
	@Column(name = "TIPO_RATEIO")
	Integer tipo_rateio;
	@Column(name = "VALOR_PERCENTUAL_RATEIO")
	Double valor_percentual_rateio;
	@Column(name = "STATUS_GER")
	String status_ger;
	@Column(name = "DATA_CALENDARIO")
	Date data_calendario;

	@Transient
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public Long getId_registro_online() {
		return id_registro_online;
	}

	public void setId_registro_online(Long id_registro_online) {
		this.id_registro_online = id_registro_online;
	}

	public String getNum_cobranca() {
		return num_cobranca;
	}

	public void setNum_cobranca(String num_cobranca) {
		this.num_cobranca = num_cobranca;
	}

	public String getCod_cuenta() {
		return cod_cuenta;
	}

	public void setCod_cuenta(String cod_cuenta) {
		this.cod_cuenta = cod_cuenta;
	}

	public Short getTipo_ambiente() {
		return tipo_ambiente;
	}

	public void setTipo_ambiente(Short tipo_ambiente) {
		this.tipo_ambiente = tipo_ambiente;
	}

	public Short getTipo_registro() {
		return tipo_registro;
	}

	public void setTipo_registro(Short tipo_registro) {
		this.tipo_registro = tipo_registro;
	}

	public Short getTipo_cobranca() {
		return tipo_cobranca;
	}

	public void setTipo_cobranca(Short tipo_cobranca) {
		this.tipo_cobranca = tipo_cobranca;
	}

	public String getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public String getSubproduto() {
		return subproduto;
	}

	public void setSubproduto(String subproduto) {
		this.subproduto = subproduto;
	}

	public String getIdentificador_titulo_empresa() {
		return identificador_titulo_empresa;
	}

	public void setIdentificador_titulo_empresa(String identificador_titulo_empresa) {
		this.identificador_titulo_empresa = identificador_titulo_empresa;
	}

	public String getTitulo_aceite() {
		return titulo_aceite;
	}

	public void setTitulo_aceite(String titulo_aceite) {
		this.titulo_aceite = titulo_aceite;
	}

	public String getTipo_carteira_titulo() {
		return tipo_carteira_titulo;
	}

	public void setTipo_carteira_titulo(String tipo_carteira_titulo) {
		this.tipo_carteira_titulo = tipo_carteira_titulo;
	}

	public String getNosso_numero() {
		return nosso_numero;
	}

	public void setNosso_numero(String nosso_numero) {
		this.nosso_numero = nosso_numero;
	}

	public String getDig_verificador_nosso_numero() {
		return dig_verificador_nosso_numero;
	}

	public void setDig_verificador_nosso_numero(String dig_verificador_nosso_numero) {
		this.dig_verificador_nosso_numero = dig_verificador_nosso_numero;
	}

	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}

	public String getData_vencimento() {

		if (data_vencimento != null)
			return formatter.format(data_vencimento);
		else
			return "";

	}

	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_cobrado() {
		
		return XPUtil.converteFrmtDecimalBancario(valor_cobrado);
	}

	public void setValor_cobrado(Double valor_cobrado) {
		this.valor_cobrado = valor_cobrado;
	}

	public String getSeu_numero() {
		return seu_numero;
	}

	public void setSeu_numero(String seu_numero) {
		this.seu_numero = seu_numero;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getData_emissao() {

		if (data_emissao != null)
			return formatter.format(data_emissao);
		else
			return "";

	}

	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}

	public String getData_limite_pagamento() {

		if (data_limite_pagamento != null)
			return formatter.format(data_limite_pagamento);
		else
			return "";

	}

	public void setData_limite_pagamento(Date data_limite_pagamento) {
		this.data_limite_pagamento = data_limite_pagamento;
	}

	public Short getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(Short tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}

	public Boolean getIndicador_pagamento_parcial() {
		return indicador_pagamento_parcial;
	}

	public void setIndicador_pagamento_parcial(Boolean indicador_pagamento_parcial) {
		this.indicador_pagamento_parcial = indicador_pagamento_parcial;
	}

	public String getQuantidade_pagamento_parcial() {
		if (quantidade_pagamento_parcial != null)
			return quantidade_pagamento_parcial.toString();
		else
			return "";

	}

	public void setQuantidade_pagamento_parcial(Short quantidade_pagamento_parcial) {
		this.quantidade_pagamento_parcial = quantidade_pagamento_parcial;
	}

	public String getQuantidade_parcelas() {
		
		if (quantidade_parcelas != null)
			return quantidade_parcelas.toString();
		else
			return "";

	}

	public void setQuantidade_parcelas(Short quantidade_parcelas) {
		this.quantidade_parcelas = quantidade_parcelas;
	}

	public String getInstrucao_cobranca_1() {
		return instrucao_cobranca_1;
	}

	public void setInstrucao_cobranca_1(String instrucao_cobranca_1) {
		this.instrucao_cobranca_1 = instrucao_cobranca_1;
	}

	public String getQuantidade_dias_1() {
		
		if (quantidade_dias_1 != null)
			return quantidade_dias_1.toString();
		else
			return "";

	}

	public void setQuantidade_dias_1(Short quantidade_dias_1) {
		this.quantidade_dias_1 = quantidade_dias_1;
	}

	public String getDATA_INSTRUCAO_1() {

		if (DATA_INSTRUCAO_1 != null)
			return formatter.format(DATA_INSTRUCAO_1);
		else
			return "";

	}

	public void setDATA_INSTRUCAO_1(Date dATA_INSTRUCAO_1) {
		DATA_INSTRUCAO_1 = dATA_INSTRUCAO_1;
	}

	public String getInstrucao_cobranca_2() {
		return instrucao_cobranca_2;
	}

	public void setInstrucao_cobranca_2(String instrucao_cobranca_2) {
		this.instrucao_cobranca_2 = instrucao_cobranca_2;
	}

	public String getQuantidade_dias_2() {
		
		if (quantidade_dias_2 != null)
			return quantidade_dias_2.toString();
		else
			return "";
		

	}

	public void setQuantidade_dias_2(Short quantidade_dias_2) {
		this.quantidade_dias_2 = quantidade_dias_2;
	}

	public String getData_instrucao_2() {

		if (data_instrucao_2 != null)
			return formatter.format(data_instrucao_2);
		else
			return "";

	}

	public void setData_instrucao_2(Date data_instrucao_2) {
		this.data_instrucao_2 = data_instrucao_2;
	}

	public String getInstrucao_cobranca_3() {
		return instrucao_cobranca_3;
	}

	public void setInstrucao_cobranca_3(String instrucao_cobranca_3) {
		this.instrucao_cobranca_3 = instrucao_cobranca_3;
	}

	public String getQuantidade_dias_3() {
		
		if (quantidade_dias_3 != null)
			return quantidade_dias_3.toString();
		else
			return "";

	}

	public void setQuantidade_dias_3(Short quantidade_dias_3) {
		this.quantidade_dias_3 = quantidade_dias_3;
	}

	public String getData_instrucao_3() {

		if (data_instrucao_3 != null)
			return formatter.format(data_instrucao_3);
		else
			return "";

	}

	public void setData_instrucao_3(Date data_instrucao_3) {
		this.data_instrucao_3 = data_instrucao_3;
	}

	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_abatimento() {
		return XPUtil.converteFrmtDecimalBancario(valor_abatimento);
	}

	public void setValor_abatimento(Double valor_abatimento) {
		this.valor_abatimento = valor_abatimento;
	}

	public String getCpf_cnpj_beneficiario() {
		return cpf_cnpj_beneficiario;
	}

	public void setCpf_cnpj_beneficiario(String cpf_cnpj_beneficiario) {
		this.cpf_cnpj_beneficiario = cpf_cnpj_beneficiario;
	}

	public String getAgencia_beneficiario() {
		return agencia_beneficiario;
	}

	public void setAgencia_beneficiario(String agencia_beneficiario) {
		this.agencia_beneficiario = agencia_beneficiario;
	}

	public String getConta_beneficiario() {
		return conta_beneficiario;
	}

	public void setConta_beneficiario(String conta_beneficiario) {
		this.conta_beneficiario = conta_beneficiario;
	}

	public String getDig_verificador_conta_benef() {
		return dig_verificador_conta_benef;
	}

	public void setDig_verificador_conta_benef(String dig_verificador_conta_benef) {
		this.dig_verificador_conta_benef = dig_verificador_conta_benef;
	}

	public String getCpf_cnpj_pagador() {
		return cpf_cnpj_pagador;
	}

	public void setCpf_cnpj_pagador(String cpf_cnpj_pagador) {
		this.cpf_cnpj_pagador = cpf_cnpj_pagador;
	}

	public String getNome_pagador() {
		return nome_pagador;
	}

	public void setNome_pagador(String nome_pagador) {
		this.nome_pagador = nome_pagador;
	}

	public String getLogradouro_pagador() {
		return logradouro_pagador;
	}

	public void setLogradouro_pagador(String logradouro_pagador) {
		this.logradouro_pagador = logradouro_pagador;
	}

	public String getBairro_pagador() {
		return bairro_pagador;
	}

	public void setBairro_pagador(String bairro_pagador) {
		this.bairro_pagador = bairro_pagador;
	}

	public String getCidade_pagador() {
		return cidade_pagador;
	}

	public void setCidade_pagador(String cidade_pagador) {
		this.cidade_pagador = cidade_pagador;
	}

	public String getUf_pagador() {
		return uf_pagador;
	}

	public void setUf_pagador(String uf_pagador) {
		this.uf_pagador = uf_pagador;
	}

	public String getCep_pagador() {
		return cep_pagador;
	}

	public void setCep_pagador(String cep_pagador) {
		this.cep_pagador = cep_pagador;
	}

	public String getEmail_pagador() {
		return email_pagador;
	}

	public void setEmail_pagador(String email_pagador) {
		this.email_pagador = email_pagador;
	}

	public String getCpf_cnpj_sacador_avalista() {
		return cpf_cnpj_sacador_avalista;
	}

	public void setCpf_cnpj_sacador_avalista(String cpf_cnpj_sacador_avalista) {
		this.cpf_cnpj_sacador_avalista = cpf_cnpj_sacador_avalista;
	}

	public String getNome_sacador_avalista() {
		return nome_sacador_avalista;
	}

	public void setNome_sacador_avalista(String nome_sacador_avalista) {
		this.nome_sacador_avalista = nome_sacador_avalista;
	}

	public String getLogradouro_sacador_avalista() {
		return logradouro_sacador_avalista;
	}

	public void setLogradouro_sacador_avalista(String logradouro_sacador_avalista) {
		this.logradouro_sacador_avalista = logradouro_sacador_avalista;
	}

	public String getBairro_sacador_avalista() {
		return bairro_sacador_avalista;
	}

	public void setBairro_sacador_avalista(String bairro_sacador_avalista) {
		this.bairro_sacador_avalista = bairro_sacador_avalista;
	}

	public String getCidade_sacador_avalista() {
		return cidade_sacador_avalista;
	}

	public void setCidade_sacador_avalista(String cidade_sacador_avalista) {
		this.cidade_sacador_avalista = cidade_sacador_avalista;
	}

	public String getUf_sacador_avalista() {
		return uf_sacador_avalista;
	}

	public void setUf_sacador_avalista(String uf_sacador_avalista) {
		this.uf_sacador_avalista = uf_sacador_avalista;
	}

	public String getCep_sacador_avalista() {
		return cep_sacador_avalista;
	}

	public void setCep_sacador_avalista(String cep_sacador_avalista) {
		this.cep_sacador_avalista = cep_sacador_avalista;
	}

	public String getCodigo_moeda_cnab() {
		return codigo_moeda_cnab;
	}

	public void setCodigo_moeda_cnab(String codigo_moeda_cnab) {
		this.codigo_moeda_cnab = codigo_moeda_cnab;
	}

	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getQuantidade_moeda() {
		return XPUtil.converteFrmtDecimalBancario(quantidade_moeda) ;
	}

	public void setQuantidade_moeda(Double quantidade_moeda) {
		this.quantidade_moeda = quantidade_moeda;
	}

	public String getData_juros() {

		if (data_juros != null)
			return formatter.format(data_juros);
		else
			return "";
	}

	public void setData_juros(Date data_juros) {
		this.data_juros = data_juros;
	}

	public Short getTipo_juros() {
		return tipo_juros;
	}

	public void setTipo_juros(Short tipo_juros) {
		this.tipo_juros = tipo_juros;
	}

	
	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 * 
	 */
	public String getValor_juros() {		
		return XPUtil.converteFrmtDecimalBancario(valor_juros);
	}

	public void setValor_juros(Double valor_juros) {
		this.valor_juros = valor_juros;
	}

	/**
	 * @return  999999900000 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getPercentual_juros() {
		return XPUtil.converteFrmtDecimalBancario(percentual_juros, 12, 4);
	}

	public void setPercentual_juros(Double percentual_juros) {
		this.percentual_juros = percentual_juros;
	}

	public String getData_multa() {
		if (data_multa != null)
			return formatter.format(data_multa);
		else
			return "";

	}

	public void setData_multa(Date data_multa) {
		this.data_multa = data_multa;
	}

	public Short getTipo_multa() {
		return tipo_multa;
	}

	public void setTipo_multa(Short tipo_multa) {
		this.tipo_multa = tipo_multa;
	}

	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_multa() {
		return XPUtil.converteFrmtDecimalBancario(valor_multa);
	}

	public void setValor_multa(Double valor_multa) {
		this.valor_multa = valor_multa;
	}

	/**
	 * @return 999999900000 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getPercentual_multa() {
		return XPUtil.converteFrmtDecimalBancario(percentual_multa,12,4);
	}

	public void setPercentual_multa(Double percentual_multa) {
		this.percentual_multa = percentual_multa;
	}

	public String getData_desconto() {

		if (data_desconto != null)
			return formatter.format(data_desconto);
		else
			return "";

	}

	public void setData_desconto(Date data_desconto) {
		this.data_desconto = data_desconto;
	}

	public Short getTipo_desconto() {
		return tipo_desconto;
	}

	public void setTipo_desconto(Short tipo_desconto) {
		this.tipo_desconto = tipo_desconto;
	}

	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_desconto() {
		return XPUtil.converteFrmtDecimalBancario(valor_desconto) ;
	}

	public void setValor_desconto(Double valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	/**
	 * @return 999999900000 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getPercentual_desconto() {
		return XPUtil.converteFrmtDecimalBancario(percentual_desconto,12,4);
	}

	public void setPercentual_desconto(Double percentual_desconto) {
		this.percentual_desconto = percentual_desconto;
	}

	public String getTipo_autorizacao_recebimento() {
		return tipo_autorizacao_recebimento;
	}

	public void setTipo_autorizacao_recebimento(String tipo_autorizacao_recebimento) {
		this.tipo_autorizacao_recebimento = tipo_autorizacao_recebimento;
	}

	public String getTipo_valor_percentual_receb() {
		return tipo_valor_percentual_receb;
	}

	public void setTipo_valor_percentual_receb(String tipo_valor_percentual_receb) {
		this.tipo_valor_percentual_receb = tipo_valor_percentual_receb;
	}

	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_minimo_recebimento() {
		return  XPUtil.converteFrmtDecimalBancario(valor_minimo_recebimento);
	}

	public void setValor_minimo_recebimento(Double valor_minimo_recebimento) {
		this.valor_minimo_recebimento = valor_minimo_recebimento;
	}

	/**
	 * @return 999999900000 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getPercentual_minimo_receb() {
		return  XPUtil.converteFrmtDecimalBancario(percentual_minimo_receb,12,4);
	}

	public void setPercentual_minimo_receb(Double percentual_minimo_receb) {
		this.percentual_minimo_receb = percentual_minimo_receb;
	}
	
	/**
	 * @return 99999999999999900 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_maximo_recebimento() {
		return  XPUtil.converteFrmtDecimalBancario(valor_maximo_recebimento);
	}

	public void setValor_maximo_recebimento(Double valor_maximo_recebimento) {
		this.valor_maximo_recebimento = valor_maximo_recebimento;
	}

	/**
	 * @return 999999900000 (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getPercentual_recebimento() {
		return  XPUtil.converteFrmtDecimalBancario(percentual_recebimento,12,4);
	}

	public void setPercentual_recebimento(Double percentual_recebimento) {
		this.percentual_recebimento = percentual_recebimento;
	}

	public String getAgencia_grupo_rateio() {
		return agencia_grupo_rateio;
	}

	public void setAgencia_grupo_rateio(String agencia_grupo_rateio) {
		this.agencia_grupo_rateio = agencia_grupo_rateio;
	}

	public String getConta_grupo_rateio() {
		return conta_grupo_rateio;
	}

	public void setConta_grupo_rateio(String conta_grupo_rateio) {
		this.conta_grupo_rateio = conta_grupo_rateio;
	}

	public String getDig_verif_conta_grupo_rateio() {
		return dig_verif_conta_grupo_rateio;
	}

	public void setDig_verif_conta_grupo_rateio(String dig_verif_conta_grupo_rateio) {
		this.dig_verif_conta_grupo_rateio = dig_verif_conta_grupo_rateio;
	}

	public Integer getTipo_rateio() {
		return tipo_rateio;
	}

	public void setTipo_rateio(Integer tipo_rateio) {
		this.tipo_rateio = tipo_rateio;
	}

	/**
	 * @return 99999999999900000  (9 - Digito inteiro. 0 - Casa decimal)
	 */
	public String getValor_percentual_rateio() {
		return XPUtil.converteFrmtDecimalBancario(valor_percentual_rateio,17,4);
	}

	public void setValor_percentual_rateio(Double valor_percentual_rateio) {
		this.valor_percentual_rateio = valor_percentual_rateio;
	}

	public String getStatus_ger() {
		return status_ger;
	}

	public void setStatus_ger(String status_ger) {
		this.status_ger = status_ger;
	}

	public String getData_calendario() {

		if (data_calendario != null)
			return formatter.format(data_calendario);
		else
			return "";

	}

	public void setData_calendario(Date data_calendario) {
		this.data_calendario = data_calendario;
	}

}
