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
public @Data class VendaProduto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_venda", referencedColumnName="codigo")
    private Venda venda;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_produto", referencedColumnName="codigo")
    private Produto produto;
	
	@NotNull
    private Double quantidade;
	
	@NotNull
    private Double valor;

    public VendaProduto() {
    }

	public VendaProduto(Long codigo) {
		super();
		this.codigo = codigo;
	}

	public VendaProduto(Long codigo, Venda venda, Produto produto,
			Double quantidade, Double valor) {
		this.codigo = codigo;
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
}
