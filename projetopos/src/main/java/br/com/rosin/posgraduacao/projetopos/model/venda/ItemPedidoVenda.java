/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.venda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.rosin.posgraduacao.projetopos.model.produto.Produto;
import lombok.Data;

/**
 * @author Roberto
 * @data 07/10/2014
 */
@Entity
@Table(name="venda_item_pedido_venda")
public @Data class ItemPedidoVenda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private Double quantidade;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="codigo_pedido")
	private PedidoVenda pedido;
	
	@ManyToOne
	@JoinColumn(name="codigo_produto")
	private Produto produto;
	
	public ItemPedidoVenda() {
	}
	
	public ItemPedidoVenda(Integer codigo) {
		this.codigo = codigo;
	}
	
	public ItemPedidoVenda(Integer codigo, Double quantidade, Double valor) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor = valor;
	}
}
