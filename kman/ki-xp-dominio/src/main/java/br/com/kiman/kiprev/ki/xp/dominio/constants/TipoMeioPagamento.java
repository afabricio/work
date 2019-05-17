package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum TipoMeioPagamento {

	DEBITO("CB", "Conta Banc�ria"), CONSIGNACAO("CN", "Consigna��o"), CHEQUE(
			"CQ", "Cheque"), CARNE("CR", "Carn�"), CARTAO("CT",
			"Cart�o de cr�dito ou d�bito"), PAGAMENTO_CHEQUE("CX",
			"Pagamento Cheque DEVOLU��ES"), DEPOSITO("DB", "Dep�sito Banc�rio"), DOC(
			"DC", "DOC"), DESCONTO_FOLHA("DF", "Desconto em folha"), FICHA(
			"FC", "Ficha de compensa��o"), RECIBO("RC", "RECIBO"), TED("TD",
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
