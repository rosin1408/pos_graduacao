package br.com.rosin.posgraduacao.projetopos.model.compra;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import br.com.rosin.posgraduacao.projetopos.model.produto.Produto;

/**
 * 
 * @author Roberto
 * @data 14/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="venda_item_pedido_venda")
public @Data class ItemPedidoCompra implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private Double quantidade;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="codigo_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="codigo_pedido")
	private PedidoCompra pedido;
	
	public ItemPedidoCompra() {
	}

	public ItemPedidoCompra(Integer codigo) {
		this.codigo = codigo;
	}
}
