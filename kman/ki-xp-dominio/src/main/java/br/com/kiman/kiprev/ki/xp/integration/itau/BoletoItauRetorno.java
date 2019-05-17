package br.com.kiman.kiprev.ki.xp.integration.itau;

public class BoletoItauRetorno {
	
	private int httpResponseCode;;
	private SucessoBoletoItauRetorno retornoSucesso;
	private ErroBoletoItauRetorno retornoErro;
	
	public int getHttpResponseCode() {
		return httpResponseCode;
	}
	public void setHttpResponseCode(int httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
	}
	public SucessoBoletoItauRetorno getRetornoSucesso() {
		return retornoSucesso;
	}
	public void setRetornoSucesso(SucessoBoletoItauRetorno retornoSucesso) {
		this.retornoSucesso = retornoSucesso;
	}
	public ErroBoletoItauRetorno getRetornoErro() {
		return retornoErro;
	}
	public void setRetornoErro(ErroBoletoItauRetorno retornoErro) {
		this.retornoErro = retornoErro;
	}

	
	
	
}
