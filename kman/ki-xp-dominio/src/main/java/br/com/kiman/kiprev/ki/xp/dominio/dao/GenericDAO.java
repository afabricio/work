package br.com.kiman.kiprev.ki.xp.dominio.dao;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GenericDAO {

	@PersistenceContext
	protected EntityManager em;

	public <T> T create(T t) {

		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;

	}

	public <T> T find(Object id, Class<T> type) {

		return (T) this.em.find(type, id);
	}

	public <T> T update(T t) {
		return (T) this.em.merge(t);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNamedQuery(String namedQuery) {
		return this.em.createNamedQuery(namedQuery).getResultList();
	}

	public <T> List<T> findByNamedQuery(String namedQuery, QueryParameters queryParameter) {
		return findByNamedQuery(namedQuery, queryParameter, 0);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByNamedQuery(String namedQuery, QueryParameters queryParameter, int resultLimit) {
		Set<Entry<String, Parameter>> rawParameters = queryParameter.getParameters().entrySet();
		Query query = this.em.createNamedQuery(namedQuery);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Parameter> entry : rawParameters) {
			Parameter param = entry.getValue();

			query.setParameter(entry.getKey(), param.getValue());
		}

		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public <T> T findSingleByNamedQuery(String namedQuery, QueryParameters queryParameter,  Class<T> type) {
		Set<Entry<String, Parameter>> rawParameters = queryParameter.getParameters().entrySet();
		
		
		TypedQuery<T> query = this.em.createNamedQuery(namedQuery, type);

		for (Entry<String, Parameter> entry : rawParameters) {
			Parameter param = entry.getValue();

			query.setParameter(entry.getKey(), param.getValue());
		}

		return query.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	public <T> T findByNativeQuery(String nativeQuery, QueryParameters queryParameter, Class<T> returnType) {

		Query query = this.em.createNativeQuery(nativeQuery);

		int c = 1;
		for (Entry<String, Parameter> entry : queryParameter.getParameters().entrySet()) {

			query.setParameter(c++, entry.getValue().getValue());
		}

		String result = query.getSingleResult().toString();

		if (returnType.equals(String.class)) {
			return (T) result;
		} else if (returnType.equals(Integer.class)) {
			return (T) new Integer(result);
		} else if (returnType.equals(Long.class)) {
			return (T) new Long(result);
		} else if (returnType.equals(Float.class)) {
			return (T) new Float(result);
		} else if (returnType.equals(Double.class)) {
			return (T) new Double(result);
		} else if (returnType.equals(Date.class)) {

			try {
				return (T) new SimpleDateFormat().parse(result);
			} catch (ParseException e) {
				throw new RuntimeException();
			}

		} else {
			return (T) result;
		}

	}

	@SuppressWarnings("unchecked")
	public <T> T executeFunction(String funcao, QueryParameters queryParameter, Class<T> returnType) {

		Set<Entry<String, Parameter>> rawParameters = queryParameter.getParameters().entrySet();

		StringBuilder pramBuilder = new StringBuilder();

		boolean first = true;
		for (String key : queryParameter.getParameters().keySet()) {
			if (!first) {
				pramBuilder.append(",");
			} else {
				first = false;
			}

			pramBuilder.append("?" + key);
		}

		String queryText = String.format("SELECT %s( %s ) FROM DUAL ", funcao, pramBuilder.toString());

		Query query = this.em.createNativeQuery(queryText);

		for (Entry<String, Parameter> entry : rawParameters) {
			Parameter param = entry.getValue();
			query.setParameter(entry.getKey(), param.getValue());
		}

		String result = query.getSingleResult().toString();

		if (returnType.equals(String.class)) {
			return (T) result;
		} else if (returnType.equals(Integer.class)) {
			return (T) new Integer(result);
		} else if (returnType.equals(Long.class)) {
			return (T) new Long(result);
		} else if (returnType.equals(Float.class)) {
			return (T) new Float(result);
		} else if (returnType.equals(Double.class)) {
			return (T) new Double(result);
		} else if (returnType.equals(Date.class)) {

			try {
				return (T) new SimpleDateFormat().parse(result);
			} catch (ParseException e) {
				throw new RuntimeException();
			}

		} else {
			return (T) result;
		}

	}

	/**
	 * 
	 * Executa uma Procedure em processo unico (Registra e executa)
	 * 
	 * @param procName
	 * @param queryParameter
	 * @return
	 */
	public OutMap executeProcedure(String procName, QueryParameters queryParameter) {
		Set<Entry<String, Parameter>> inParameters = queryParameter.getParameters().entrySet();
		Set<Entry<String, Parameter>> outParameters = queryParameter.getOutParameters().entrySet();

		StoredProcedureQuery proc = em.createStoredProcedureQuery(String.format("{ call %s}", procName));

		for (Entry<String, Parameter> entry : inParameters) {
			Parameter param = entry.getValue();

			if (!queryParameter.getOutParameters().containsKey(entry.getKey())) {
				proc.registerStoredProcedureParameter(entry.getKey(), param.getClazz(), ParameterMode.IN);

			} else {
				proc.registerStoredProcedureParameter(entry.getKey(), param.getClazz(), ParameterMode.INOUT);
			}

			proc.setParameter(entry.getKey(), param.getValue());
		}

		for (Entry<String, Parameter> entry : outParameters) {

			if (!queryParameter.getParameters().containsKey(entry.getKey())) {
				Parameter outParam = entry.getValue();
				proc.registerStoredProcedureParameter(entry.getKey(), outParam.getClazz(), ParameterMode.OUT);
			}
		}

		proc.execute();

		for (Entry<String, Parameter> entry : outParameters) {
			Parameter outParam = entry.getValue();
			outParam.setValue(proc.getOutputParameterValue(entry.getKey()));
		}

		proc.getSingleResult();
		return queryParameter.getOutParameters();

	}

	/**
	 * Registra procedure para realizar a excução posteriormente.
	 * 
	 * @param procName
	 * @param queryParameter
	 * @return
	 */
	public StoredProcedureQuery registerProcedure(String procName, QueryParameters queryParameter) {
		Set<Entry<String, Parameter>> inParameters = queryParameter.getParameters().entrySet();
		Set<Entry<String, Parameter>> outParameters = queryParameter.getOutParameters().entrySet();

		StoredProcedureQuery register = em.createStoredProcedureQuery(String.format("{ call %s}", procName));

		for (Entry<String, Parameter> entry : inParameters) {
			Parameter param = entry.getValue();
			if (!queryParameter.getOutParameters().containsKey(entry.getKey())) {
				register.registerStoredProcedureParameter(entry.getKey(), param.getClazz(), ParameterMode.IN);

			} else {
				register.registerStoredProcedureParameter(entry.getKey(), param.getClazz(), ParameterMode.INOUT);
			}

		}

		for (Entry<String, Parameter> entry : outParameters) {
			Parameter outParam = entry.getValue();
			if (!queryParameter.getParameters().containsKey(entry.getKey())) {
				register.registerStoredProcedureParameter(entry.getKey(), outParam.getClazz(), ParameterMode.OUT);
			}
		}

		return register;
	}

	/**
	 * executa procedure utilizando StoredProcedureQuery registrada anteriormente.
	 * 
	 * @param proc
	 * @param queryParameter
	 * @return
	 */
	public OutMap executeStoredProcedure(StoredProcedureQuery proc, QueryParameters queryParameter) {
		Set<Entry<String, Parameter>> inParameters = queryParameter.getParameters().entrySet();
		Set<Entry<String, Parameter>> outParameters = queryParameter.getOutParameters().entrySet();

		for (Entry<String, Parameter> entry : inParameters) {

			Parameter param = entry.getValue();
			proc.setParameter(entry.getKey(), param.getValue());
		}

		proc.execute();

		for (Entry<String, Parameter> entry : outParameters) {
			Parameter outParam = entry.getValue();
			outParam.setValue(proc.getOutputParameterValue(entry.getKey()));

		}

		proc.getSingleResult();

		return queryParameter.getOutParameters();

	}

	/**
	 * Executa procedure utilizando NamedProcedure, OBS: não funciona output
	 * parameters
	 * 
	 * @param procName
	 * @param queryParameter
	 * @return
	 */
	public Map<String, Object> executeProcedureByNamedProcedure(String procName, QueryParameters queryParameter) {
		Set<Entry<String, Parameter>> inParameters = queryParameter.getParameters().entrySet();
		Set<Entry<String, Parameter>> outParameters = queryParameter.getOutParameters().entrySet();

		StoredProcedureQuery proc = em.createNamedStoredProcedureQuery(procName);

		for (Entry<String, Parameter> entry : inParameters) {
			Parameter param = entry.getValue();
			proc.setParameter(entry.getKey(), param.getValue());
		}

		proc.execute();

		Map<String, Object> outs = new HashMap<String, Object>();
		for (Entry<String, Parameter> entry : outParameters) {
			outs.put(entry.getKey(), proc.getOutputParameterValue(entry.getKey()));
		}

		proc.getSingleResult();
		return outs;
	}

	private static final String BARRA = "/";
	private static final String QUERY_PARAM_GENERALES = " SELECT valor FROM kiprev.param_generales WHERE abrev_parametro = ?1 ";

	public String buscaUrlJasper() {
		String dominio = findByNativeQuery(QUERY_PARAM_GENERALES, with("JASPER_DOMAIN"), String.class);
		String contexto = findByNativeQuery(QUERY_PARAM_GENERALES, with("JASPER_CONTEXT"), String.class);
		String servico = findByNativeQuery(QUERY_PARAM_GENERALES, with("JASPER_SERVICE"), String.class);
		return new StringBuilder(dominio).append(BARRA).append(contexto).append(BARRA).append(servico).toString();
	}

}
