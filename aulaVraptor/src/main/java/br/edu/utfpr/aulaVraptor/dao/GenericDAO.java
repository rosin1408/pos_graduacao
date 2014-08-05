package br.edu.utfpr.aulaVraptor.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO <T>{
	
	@PersistenceContext
	protected EntityManager em;
	
	public void inserir(T entidade) {
		em.persist(entidade);
	}
	
	public void alterar(T entidade) {
		em.merge(entidade);
	}
	
	public void remover(Class<T> aClass, Long codigo) {
		em.remove(em.getReference(aClass, codigo));
	}
}
