package br.com.kiman.kiprev.ki.xp.integration.itau;

public class BoletoItauEntrada {
	private Short tipo_ambiente;
	private Short tipo_registro;
	private Short tipo_cobranca;
	private String tipo_produto;
	private String subproduto;
	private BeneficiarioEntrada beneficiario;
	private String identificador_titulo_empresa;
	private String uso_banco;
	private String titulo_aceite;
	private PagadorEntrada pagador;
	private String tipo_carteira_titulo;
	private MoedaEntrada moeda;
	private String nosso_numero;
	private String digito_verificador_nosso_numero;
	private String codigo_barras;
	private String data_vencimento;
	private String valor_cobrado;
	private String seu_numero;
	private String especie;
	private String data_emissao;
	private String data_limite_pagamento;
	private Short tipo_pagamento;
	private Boolean indicador_pagamento_parcial;
	private String quantidade_pagamento_parcial;
	private String quantidade_parcelas;
	private String instrucao_cobranca_1;
	private String quantidade_dias_1;
	private String data_instrucao_1;
	private String instrucao_cobranca_2;
	private String quantidade_dias_2;
	private String data_instrucao_2;
	private String instrucao_cobranca_3;
	private String quantidade_dias_3;
	private String data_instrucao_3;
	private String valor_abatimento;
	private Juros juros;
	private Multa multa;
	private Grupo_desconto grupo_desconto[];
	private Recebimento_divergente recebimento_divergente;

	public BoletoItauEntrada() {
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

	public BeneficiarioEntrada getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(BeneficiarioEntrada beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getIdentificador_titulo_empresa() {
		return identificador_titulo_empresa;
	}

	public void setIdentificador_titulo_empresa(String identificador_titulo_empresa) {
		this.identificador_titulo_empresa = identificador_titulo_empresa;
	}

	public String getUso_banco() {
		return uso_banco;
	}

	public void setUso_banco(String uso_banco) {
		this.uso_banco = uso_banco;
	}

	public String getTitulo_aceite() {
		return titulo_aceite;
	}

	public void setTitulo_aceite(String titulo_aceite) {
		this.titulo_aceite = titulo_aceite;
	}

	public PagadorEntrada getPagador() {
		return pagador;
	}

	public void setPagador(PagadorEntrada pagador) {
		this.pagador = pagador;
	}

	public String getTipo_carteira_titulo() {
		return tipo_carteira_titulo;
	}
	
	public void setTipo_carteira_titulo(String tipo_carteira_titulo) {
		this.tipo_carteira_titulo = tipo_carteira_titulo;
	}

	public MoedaEntrada getMoeda() {
		return moeda;
	}

	public void setMoeda(MoedaEntrada moeda) {
		this.moeda = moeda;
	}

	public String getNosso_numero() {
		return nosso_numero;
	}

	public void setNosso_numero(String nosso_numero) {
		this.nosso_numero = nosso_numero;
	}

	public String getDigito_verificador_nosso_numero() {
		return digito_verificador_nosso_numero;
	}

	public void setDigito_verificador_nosso_numero(String digito_verificador_nosso_numero) {
		this.digito_verificador_nosso_numero = digito_verificador_nosso_numero;
	}

	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}

	public String getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public String getValor_cobrado() {
		return valor_cobrado;
	}

	public void setValor_cobrado(String valor_cobrado) {
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
		return data_emissao;
	}

	public void setData_emissao(String data_emissao) {
		this.data_emissao = data_emissao;
	}

	public String getData_limite_pagamento() {
		return data_limite_pagamento;
	}

	public void setData_limite_pagamento(String data_limite_pagamento) {
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
		return quantidade_pagamento_parcial;
	}

	public void setQuantidade_pagamento_parcial(String quantidade_pagamento_parcial) {
		this.quantidade_pagamento_parcial = quantidade_pagamento_parcial;
	}

	public String getQuantidade_parcelas() {
		return quantidade_parcelas;
	}

	public void setQuantidade_parcelas(String quantidade_parcelas) {
		this.quantidade_parcelas = quantidade_parcelas;
	}

	public String getInstrucao_cobranca_1() {
		return instrucao_cobranca_1;
	}

	public void setInstrucao_cobranca_1(String instrucao_cobranca_1) {
		this.instrucao_cobranca_1 = instrucao_cobranca_1;
	}
	
	public String getQuantidade_dias_1() {
		return quantidade_dias_1;
	}

	public void setQuantidade_dias_1(String quantidade_dias_1) {
		this.quantidade_dias_1 = quantidade_dias_1;
	}

	public String getData_instrucao_1() {
		return data_instrucao_1;
	}

	public void setData_instrucao_1(String data_instrucao_1) {
		this.data_instrucao_1 = data_instrucao_1;
	}

	public String getInstrucao_cobranca_2() {
		return instrucao_cobranca_2;
	}

	public void setInstrucao_cobranca_2(String instrucao_cobranca_2) {
		this.instrucao_cobranca_2 = instrucao_cobranca_2;
	}

	public String getQuantidade_dias_2() {
		return quantidade_dias_2;
	}

	public void setQuantidade_dias_2(String quantidade_dias_2) {
		this.quantidade_dias_2 = quantidade_dias_2;
	}

	public String getData_instrucao_2() {
		return data_instrucao_2;
	}

	public void setData_instrucao_2(String data_instrucao_2) {
		this.data_instrucao_2 = data_instrucao_2;
	}

	public String getInstrucao_cobranca_3() {
		return instrucao_cobranca_3;
	}

	public void setInstrucao_cobranca_3(String instrucao_cobranca_3) {
		this.instrucao_cobranca_3 = instrucao_cobranca_3;
	}

	public String getQuantidade_dias_3() {
		return quantidade_dias_3;
	}

	public void setQuantidade_dias_3(String quantidade_dias_3) {
		this.quantidade_dias_3 = quantidade_dias_3;
	}

	public String getData_instrucao_3() {
		return data_instrucao_3;
	}

	public void setData_instrucao_3(String data_instrucao_3) {
		this.data_instrucao_3 = data_instrucao_3;
	}

	public String getValor_abatimento() {
		return valor_abatimento;
	}

	public void setValor_abatimento(String valor_abatimento) {
		this.valor_abatimento = valor_abatimento;
	}

	public Juros getJuros() {
		return juros;
	}

	public void setJuros(Juros juros) {
		this.juros = juros;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public Grupo_desconto[] getGrupo_desconto() {
		return grupo_desconto;
	}

	public void setGrupo_desconto(Grupo_desconto[] grupo_desconto) {
		this.grupo_desconto = grupo_desconto;
	}

	public Recebimento_divergente getRecebimento_divergente() {
		return recebimento_divergente;
	}

	public void setRecebimento_divergente(Recebimento_divergente recebimento_divergente) {
		this.recebimento_divergente = recebimento_divergente;
	}

}
