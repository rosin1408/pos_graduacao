package br.edu.utfpr.aulaVraptor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.edu.utfpr.aulaVraptor.model.Produto;

@Stateless
public class ProdutoDAO extends GenericDAO<Produto> {

	public List<Produto> listAll() {
		return em.createQuery("select o from Produto o", Produto.class).getResultList();
	}

	public Produto load(Long codigo) {
		TypedQuery<Produto> query = em.createQuery("select o from Produto o where o.codigo=:codigo", Produto.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	public List<Produto> list(String nome) {
		TypedQuery<Produto> query = em.createQuery("select o from Produto o where o.nome like :nome", Produto.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
}
