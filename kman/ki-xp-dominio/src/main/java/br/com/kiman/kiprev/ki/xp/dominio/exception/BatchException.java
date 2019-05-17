package br.com.kiman.kiprev.ki.xp.dominio.exception;

public class BatchException extends RuntimeException {

	private static final long serialVersionUID = 3252123086884163684L;

	public BatchException(Exception e) {
		super(e);
	}

	public BatchException(String msg) {
		super(msg);
	}

	public BatchException(String msg, Exception e) {
		super(msg, e);
	}

}
