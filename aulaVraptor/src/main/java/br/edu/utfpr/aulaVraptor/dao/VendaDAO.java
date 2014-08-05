package br.edu.utfpr.aulaVraptor.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.edu.utfpr.aulaVraptor.model.Venda;

@Stateless
public class VendaDAO extends GenericDAO<Venda> {

	public List<Venda> listAll() {
		return em.createQuery("select v from Venda v", Venda.class).getResultList();
	}

	public Venda load(Long codigo) {
		TypedQuery<Venda> query = em.createQuery("select v from Venda v where v.codigo=:codigo", Venda.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	public List<Venda> listByDataVenda(LocalDate dataVenda) {
		TypedQuery<Venda> query = em.createQuery("select v from Venda v where v.dataVenda = :dataVenda", Venda.class);
		query.setParameter("dataVenda", dataVenda);
		return query.getResultList();
	}
	
	public List<Venda> listByPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		TypedQuery<Venda> query = em.createQuery("select v from Venda v where v.dataVenda between :dataInicial and : dataFinal", Venda.class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		return query.getResultList();
	}
}
