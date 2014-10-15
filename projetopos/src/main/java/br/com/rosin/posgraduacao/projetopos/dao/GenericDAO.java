package br.com.rosin.posgraduacao.projetopos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Roberto
 * @data 14/10/2014
 */
public class GenericDAO <T> {
	
	@PersistenceContext(unitName = "PostgreSQL")
	protected EntityManager em;
	
	public T insert(T entidade) {
		em.persist(entidade);
		return entidade;
	}
	
	public void update(T entidade) {
		em.merge(entidade);
	}
	
	public void delete(Class<T> aClass, Integer codigo) {
		em.remove(em.getReference(aClass, codigo));
	}
	
	public void delete(Class<T> aClass, List<Integer> codigos) {
		for (Integer codigo : codigos) {
			em.remove(em.getReference(aClass, codigo));
		}
	}
	
	public T findByCodigo(Class<T> aClass, Integer codigo) {
		return em.find(aClass, codigo);
	}
}
