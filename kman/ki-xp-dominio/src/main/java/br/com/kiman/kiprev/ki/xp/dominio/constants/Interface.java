package br.com.kiman.kiprev.ki.xp.dominio.constants;

public enum Interface {
	PEP(5), FUNDOS(1), COTAS(2), INDICES(4), LOGIN_AD(30), ATUALIZA_CLIENTES(29), ENVIO_BOLETO_ONLINE(25),
	FOLHETERIA(33), GED(31), RETORNO_DEPOSITO_BANCARIO(37);
	

	private Integer numero;

	private Interface(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

}
