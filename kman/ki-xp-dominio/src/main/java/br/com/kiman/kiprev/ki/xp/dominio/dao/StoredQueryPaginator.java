package br.com.kiman.kiprev.ki.xp.dominio.dao;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class StoredQueryPaginator {
	@PersistenceContext
	private EntityManager em;
	private int index = 0;
	private int pageSize = 10;
	private boolean next = true;
	private String namedQuery;

	public void setNamedQuery(String namedQuery) {
		this.namedQuery = namedQuery;
		this.index = 0;
		next = true;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> next() {
		List<T> retVal = null;
		Query query = this.em.createNamedQuery(namedQuery);
		query.setFirstResult(getFirst());
		query.setMaxResults(pageSize);
		retVal = query.getResultList();
		if (retVal.size() == 0) {
			this.next = false;
		}
		index++;
		return retVal;
	}

	private int getFirst() {
		return index * pageSize;
	}

	public boolean hasNext() {
		return this.next;
	}

	public void remove() {
		throw new UnsupportedOperationException("Operation remove …");
	}

	@Remove
	public void close() {
		this.em.clear();
		this.em.close();
	}
}
