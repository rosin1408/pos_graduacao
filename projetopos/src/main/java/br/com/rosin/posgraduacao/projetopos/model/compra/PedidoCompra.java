package br.com.rosin.posgraduacao.projetopos.model.compra;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rosin.posgraduacao.projetopos.model.financeiro.ContaPagar;
import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 14/10/2014
 */
@Entity
@Table(name="compra_pedido_compra")
public @Data class PedidoCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="valor_total")
	private Double valorTotal;
	private LocalDate data;
	
	@Column(name="data_entrega")
	private LocalDate dataEntrega;
	
	@Column(name="numero_documento")
	private Long numeroDocumento;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedidoCompra> itens;
	
	@OneToOne
	@JoinColumn(name="codigo_titulo")
	private ContaPagar titulo;

	public PedidoCompra() {
	}
	
	public PedidoCompra(Integer codigo) {
		this.codigo = codigo;
	}
}
