package br.com.kiman.kiprev.ki.xp.integration.itau;

import java.util.List;

public final class ErroBoletoItauRetorno {
	private String codigo;
	private String mensagem;
	private List<Campo> campos;



	public ErroBoletoItauRetorno() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	

}
