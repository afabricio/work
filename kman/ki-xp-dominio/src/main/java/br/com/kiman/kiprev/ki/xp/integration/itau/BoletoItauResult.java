package br.com.kiman.kiprev.ki.xp.integration.itau;

public final class BoletoItauResult {
    public final Beneficiario beneficiario;
    public final Pagador pagador;
    public final Sacador_avalista sacador_avalista;
    public final Moeda moeda;
    public final String vencimento_titulo;
    public final String tipo_carteira_titulo;
    public final String nosso_numero;
    public final String seu_numero;
    public final long especie;
    public final String codigo_barras;
    public final String numero_linha_digitavel;
    public final String local_pagamento;
    public final String data_processamento;
    public final String data_emissao;
    public final String uso_banco;
    public final String valor_titulo;
    public final String valor_desconto;
    public final String valor_outra_deducao;
    public final String valor_juro_multa;
    public final String valor_outro_acrescimo;
    public final String valor_total_cobrado;
    public final String texto_informacao_cliente_beneficiario;
    public final String codigo_mensagem_erro;


    public BoletoItauResult(Beneficiario beneficiario, Pagador pagador, Sacador_avalista sacador_avalista, Moeda moeda, String vencimento_titulo, String tipo_carteira_titulo, String nosso_numero, String seu_numero, long especie, String codigo_barras, String numero_linha_digitavel, String local_pagamento, String data_processamento, String data_emissao, String uso_banco, String valor_titulo, String valor_desconto, String valor_outra_deducao, String valor_juro_multa, String valor_outro_acrescimo, String valor_total_cobrado, String texto_informacao_cliente_beneficiario, String codigo_mensagem_erro){
        this.beneficiario = beneficiario;
        this.pagador = pagador;
        this.sacador_avalista = sacador_avalista;
        this.moeda = moeda;
        this.vencimento_titulo = vencimento_titulo;
        this.tipo_carteira_titulo = tipo_carteira_titulo;
        this.nosso_numero = nosso_numero;
        this.seu_numero = seu_numero;
        this.especie = especie;
        this.codigo_barras = codigo_barras;
        this.numero_linha_digitavel = numero_linha_digitavel;
        this.local_pagamento = local_pagamento;
        this.data_processamento = data_processamento;
        this.data_emissao = data_emissao;
        this.uso_banco = uso_banco;
        this.valor_titulo = valor_titulo;
        this.valor_desconto = valor_desconto;
        this.valor_outra_deducao = valor_outra_deducao;
        this.valor_juro_multa = valor_juro_multa;
        this.valor_outro_acrescimo = valor_outro_acrescimo;
        this.valor_total_cobrado = valor_total_cobrado;
        this.texto_informacao_cliente_beneficiario = texto_informacao_cliente_beneficiario;
        this.codigo_mensagem_erro = codigo_mensagem_erro;
    }

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public Pagador getPagador() {
		return pagador;
	}

	public Sacador_avalista getSacador_avalista() {
		return sacador_avalista;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public String getVencimento_titulo() {
		return vencimento_titulo;
	}

	public String getTipo_carteira_titulo() {
		return tipo_carteira_titulo;
	}

	public String getNosso_numero() {
		return nosso_numero;
	}

	public String getSeu_numero() {
		return seu_numero;
	}

	public long getEspecie() {
		return especie;
	}

	public String getCodigo_barras() {
		return codigo_barras;
	}

	public String getNumero_linha_digitavel() {
		return numero_linha_digitavel;
	}

	public String getLocal_pagamento() {
		return local_pagamento;
	}

	public String getData_processamento() {
		return data_processamento;
	}

	public String getData_emissao() {
		return data_emissao;
	}

	public String getUso_banco() {
		return uso_banco;
	}

	public String getValor_titulo() {
		return valor_titulo;
	}

	public String getValor_desconto() {
		return valor_desconto;
	}

	public String getValor_outra_deducao() {
		return valor_outra_deducao;
	}

	public String getValor_juro_multa() {
		return valor_juro_multa;
	}

	public String getValor_outro_acrescimo() {
		return valor_outro_acrescimo;
	}

	public String getValor_total_cobrado() {
		return valor_total_cobrado;
	}

	public String getTexto_informacao_cliente_beneficiario() {
		return texto_informacao_cliente_beneficiario;
	}

	public String getCodigo_mensagem_erro() {
		return codigo_mensagem_erro;
	}

    



}