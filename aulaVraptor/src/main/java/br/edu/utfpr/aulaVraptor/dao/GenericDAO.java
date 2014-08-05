package br.edu.utfpr.aulaVraptor.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.utfpr.aulaVraptor.model.Cliente;

public class GenericDAO <T>{
	
	@PersistenceContext
	protected EntityManager em;
	
	public void inserir(T entidade) {
		em.persist(entidade);
	}
	
	public void alterar(T entidade) {
		em.merge(entidade);
	}
	
	public void remover(Long codigo) {
		em.remove(em.getReference(Cliente.class, codigo));
	}
}
