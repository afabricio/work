package br.com.kiman.kiprev.ki.xp.dominio.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -2748345296426348562L;


	public NegocioException(String message) {
		super(message);
	}


	public NegocioException(String message, Exception e) {
		super(message, e);
	}

	public NegocioException(Exception e) {
		super(e);
	}


}
