package br.edu.utfpr.aulaVraptor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.edu.utfpr.aulaVraptor.model.Categoria;

@Stateless
public class CategoriaDAO extends GenericDAO<Categoria> {

	public List<Categoria> listAll() {
		return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
	}

	public Categoria load(Long codigo) {
		TypedQuery<Categoria> query = em.createQuery("select c from Categoria c where c.codigo=:codigo", Categoria.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	public List<Categoria> list(String nome) {
		TypedQuery<Categoria> query = em.createQuery("select c from Categoria c where upper(c.nome) like upper(:nome)", Categoria.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
}
