package br.edu.utfpr.aulaVraptor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.edu.utfpr.aulaVraptor.model.Cliente;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente>{
	
	public List<Cliente> listAll() {
		return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	public Cliente load(Long codigo) {
		TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where c.codigo=:codigo", Cliente.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	public List<Cliente> list(String nome) {
		TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where upper(c.nome) like upper(:nome)", Cliente.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	
}
