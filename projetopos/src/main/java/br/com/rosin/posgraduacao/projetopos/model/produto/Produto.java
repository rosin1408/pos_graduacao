package br.com.rosin.posgraduacao.projetopos.model.produto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 10/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="produto_produto")
public @Data class Produto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private CategoriaProduto categoria;
	
	@Column(name="valor_unitario")
	private Double valorUnitario;
	
	@Column(name="data_cadastro")
	private LocalDate dataCadastro;
	
	public Produto() {
	}
	
	public Produto(Integer codigo) {
		this.codigo = codigo;
	}
}
