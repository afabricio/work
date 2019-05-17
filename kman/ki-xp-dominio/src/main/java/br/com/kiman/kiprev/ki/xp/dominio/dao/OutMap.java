package br.com.kiman.kiprev.ki.xp.dominio.dao;

import java.util.HashMap;

public class OutMap extends HashMap<String, Parameter>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8408083394427948665L;



	@SuppressWarnings("unchecked")
	public <T> T getOut(String key) {
		return (T) get(key).getValue();
	}

}
