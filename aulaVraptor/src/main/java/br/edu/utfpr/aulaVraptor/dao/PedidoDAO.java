package br.edu.utfpr.aulaVraptor.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.edu.utfpr.aulaVraptor.model.Pedido;

@Stateless
public class PedidoDAO extends GenericDAO<Pedido> {

	public List<Pedido> listAll() {
		return em.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}

	public Pedido load(Long codigo) {
		TypedQuery<Pedido> query = em.createQuery("select p from Pedido p where p.codigo=:codigo", Pedido.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}
	
	public List<Pedido> list(String numeroPedido) {
		TypedQuery<Pedido> query = em.createQuery("select p from Pedido p where p.numeroPedido like :numeroPedido", Pedido.class);
		query.setParameter("numeroPedido", "%" + numeroPedido + "%");
		return query.getResultList();
	}
	
	public List<Pedido> list(LocalDate dataPedido) {
		TypedQuery<Pedido> query = em.createQuery("select p from Pedido p where p.dataPedido = :dataPedido", Pedido.class);
		query.setParameter("dataPedido", dataPedido);
		return query.getResultList();
	}

	public List<Pedido> listByDataPedido(LocalDate dataPedido) {
		TypedQuery<Pedido> query = em.createQuery("select p from Pedido p where p.dataPedido = :dataPedido", Pedido.class);
		query.setParameter("dataPedido", dataPedido);
		return query.getResultList();
	}
	
	public List<Pedido> listByPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		TypedQuery<Pedido> query = em.createQuery("select p from Pedido p where p.dataPedido between :dataInicial and : dataFinal", Pedido.class);
		query.setParameter("dataInicial", dataInicial);
		query.setParameter("dataFinal", dataFinal);
		return query.getResultList();
	}
}
