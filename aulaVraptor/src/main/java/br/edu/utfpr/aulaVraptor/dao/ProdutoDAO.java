package br.edu.utfpr.aulaVraptor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.edu.utfpr.aulaVraptor.model.Produto;

@Stateless
public class ProdutoDAO extends GenericDAO<Produto> {

	public List<Produto> listAll() {
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public Produto load(Long codigo) {
		TypedQuery<Produto> query = em.createQuery("select p from Produto p where p.codigo=:codigo", Produto.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	public List<Produto> list(String nome) {
		TypedQuery<Produto> query = em.createQuery("select p from Produto p where upper(p.nome) like upper(:nome)", Produto.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
}
