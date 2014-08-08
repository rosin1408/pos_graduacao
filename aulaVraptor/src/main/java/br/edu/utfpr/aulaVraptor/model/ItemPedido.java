package br.edu.utfpr.aulaVraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
public @Data class ItemPedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_pedido", referencedColumnName="codigo")
    private Pedido pedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_produto", referencedColumnName="codigo")
    private Produto produto;
	
	@NotNull
    private Double quantidade;
	
	@NotNull
    private Double valor;

    public ItemPedido() {
    }

	public ItemPedido(Long codigo) {
		super();
		this.codigo = codigo;
	}

	public ItemPedido(Long codigo, Pedido pedido, Produto produto, Double quantidade, Double valor) {
		this.codigo = codigo;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
}
