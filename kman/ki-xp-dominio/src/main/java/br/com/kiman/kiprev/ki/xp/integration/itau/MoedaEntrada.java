package br.com.kiman.kiprev.ki.xp.integration.itau;

public class MoedaEntrada {
	public String codigo_moeda_cnab;
	public String quantidade_moeda;

	public MoedaEntrada(String codigo_moeda_cnab, String quantidade_moeda) {
		this.codigo_moeda_cnab = codigo_moeda_cnab;
		this.quantidade_moeda = quantidade_moeda;
	}

	public MoedaEntrada() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo_moeda_cnab() {
		return codigo_moeda_cnab;
	}

	public void setCodigo_moeda_cnab(String codigo_moeda_cnab) {
		this.codigo_moeda_cnab = codigo_moeda_cnab;
	}

	public String getQuantidade_moeda() {
		return quantidade_moeda;
	}

	public void setQuantidade_moeda(String quantidade_moeda) {
		this.quantidade_moeda = quantidade_moeda;
	}

}