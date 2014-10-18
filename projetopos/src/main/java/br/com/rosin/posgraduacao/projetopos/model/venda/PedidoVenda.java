package br.com.rosin.posgraduacao.projetopos.model.venda;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

import br.com.rosin.posgraduacao.projetopos.model.financeiro.ContaReceber;
import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 07/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="venda_pedido_venda")
public @Data class PedidoVenda implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="valor_total")
	private Double valorTotal;
	private LocalDate data;
	
	@Column(name="numero_documento")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numeroDocumento;
	
	@OneToOne
	@JoinColumn(name="codigo_titulo")
	private ContaReceber titulo;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedidoVenda> itens;
	
	public PedidoVenda() {
	}
	
	public PedidoVenda(Integer codigo) {
		this.codigo = codigo;
	}
}
