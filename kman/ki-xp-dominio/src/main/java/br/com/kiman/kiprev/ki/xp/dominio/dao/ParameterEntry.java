package br.com.kiman.kiprev.ki.xp.dominio.dao;

public class ParameterEntry<K, V>  {

	private final K valor;
	private V tipo;

	public ParameterEntry(K valor, V tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public ParameterEntry(K valor) {
		this.valor = valor;
	}

	public V getTipo() {
		return tipo;
	}

	public void setTipo(V tipo) {
		this.tipo = tipo;
	}

	public K getValor() {
		return valor;
	}

	


}
