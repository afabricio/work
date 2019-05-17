package br.com.kiman.kiprev.ki.xp.dominio.dao;

public class Parameter {
	
	private Object value;
	private Class clazz;
	
	public Parameter() {
	}
	
	public Parameter(Object value) {
		this.value = value;
	}
	public Parameter(Object value, Class<?> clazz) {
		this.value = value;
		this.clazz = clazz;
	}

	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	

	
	

}
