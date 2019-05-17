package br.com.kiman.kiprev.ki.xp.dominio.dao;

import java.util.LinkedHashMap;
import java.util.Map;

public class QueryParameters {

	private Map<String, Parameter> parameters = null;
	private OutMap outParameters = null;

	private QueryParameters(String key, Parameter param) {

		this.parameters = new LinkedHashMap<String, Parameter>();
		this.outParameters = new OutMap();
		this.parameters.put(key,param);

	}
	

	private QueryParameters() {
		this.parameters = new LinkedHashMap<String, Parameter>();
		this.outParameters = new OutMap();
	}

	public static QueryParameters noParam() {

		return new QueryParameters();
	}

	public static QueryParameters with( Object value) {

		return new QueryParameters("0", new Parameter(value));
	}
	
	public static QueryParameters with(String key, Object value) {

		return new QueryParameters(key, new Parameter(value));
	}

	public static QueryParameters with(String key, Class<?> clazz) {
		Parameter param = new Parameter();
		param.setClazz(clazz);
		return new QueryParameters(key, param);
	}

	public static QueryParameters with(String key, Object value, Class<?> clazz) {

		Parameter param = new Parameter(value);
		param.setClazz(clazz);
		
		return new QueryParameters(key, param);
	}

	public QueryParameters and(String key, Object value) {

		this.parameters.put(key, new Parameter(value));

		return this;
	}
	
	public QueryParameters and(Object value) {

		this.parameters.put(String.valueOf(this.parameters.size()), new Parameter(value));

		return this;
	}


	public QueryParameters and(String key, Class<?> clazz) {
		Parameter param = new Parameter();
		param.setClazz(clazz);

		this.parameters.put(key, param);

		return this;
	}

	public QueryParameters and(String key, Object value, Class<?> clazz) {

		this.parameters.put(key, new Parameter(value, clazz));

		return this;
	}

	public QueryParameters out(String key, Class<?> clazz) {
		Parameter param = new Parameter();
		param.setClazz(clazz);

		this.outParameters.put(key, param);

		return this;
	}
	

	public Map<String, Parameter> getParameters() {
		return parameters;
	}

	public OutMap getOutParameters() {
		return outParameters;
	}

}
