package br.com.kiman.kiprev.ki.xp.integration.itau;

public final class ErroBoletoItau {
    public final String codigo;
    public final String mensagem;
    public final Campo campos[];

    public ErroBoletoItau(String codigo, String mensagem, Campo[] campos){
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.campos = campos;
    }

	public String getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Campo[] getCampos() {
		return campos;
	}


}
