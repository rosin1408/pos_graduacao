/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.rosin.posgraduacao.projetopos.model.compra.PedidoCompra;
import br.com.rosin.posgraduacao.projetopos.model.pessoa.Fornecedor;

/**
 * @author Roberto
 * @data 06/10/2014
 */
@Entity
@Table(name="financeiro_contas_pagar")
@EqualsAndHashCode(callSuper=true)
public @Data class ContaPagar extends Titulo {
	
	@Column(name="data_pagamento")
	private LocalDate dataPagamento;
	
	@ManyToOne
	@JoinColumn(name="codigo_fornecedor")
	private Fornecedor fornecedor;
	
	@OneToOne
	@JoinColumn(name="codigo_pedido")
	private PedidoCompra pedido;
	
	public ContaPagar() {
	}
	
	public ContaPagar(Integer codigo) {
		setCodigo(codigo);
	}
	
	public ContaPagar(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
