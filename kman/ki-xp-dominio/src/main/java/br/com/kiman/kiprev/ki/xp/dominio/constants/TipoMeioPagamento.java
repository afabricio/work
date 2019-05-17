package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoMeioPagamento {

	DEBITO("CB", "Conta Bancária"), CONSIGNACAO("CN", "Consignação"), CHEQUE(
			"CQ", "Cheque"), CARNE("CR", "Carnê"), CARTAO("CT",
			"Cartão de crédito ou débito"), PAGAMENTO_CHEQUE("CX",
			"Pagamento Cheque DEVOLUÇÔES"), DEPOSITO("DB", "Depósito Bancário"), DOC(
			"DC", "DOC"), DESCONTO_FOLHA("DF", "Desconto em folha"), FICHA(
			"FC", "Ficha de compensação"), RECIBO("RC", "RECIBO"), TED("TD",
			"TED");

	private final String valor;
	private final String descricao;

	private TipoMeioPagamento(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static TipoMeioPagamento getEnum(String valor) {
		for (TipoMeioPagamento tipoEnum : TipoMeioPagamento.values()) {
			if (tipoEnum.getValor().equals(valor)) {
				return tipoEnum;
			}
		}
		return null;
	}

	public boolean isFicha() {
		return TipoMeioPagamento.FICHA.equals(this);
	}

	public boolean isDebito() {
		return TipoMeioPagamento.DEBITO.equals(this);
	}

	public boolean isCarne() {
		return TipoMeioPagamento.CARNE.equals(this);
	}

	public boolean isFichaOuCarne() {
		return isFicha() || isCarne();
	}

}
