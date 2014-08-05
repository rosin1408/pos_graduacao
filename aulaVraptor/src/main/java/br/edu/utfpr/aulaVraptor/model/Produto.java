package br.edu.utfpr.aulaVraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public @Data class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	
	@Size(max=100, min=3) @NotEmpty
	@Column(length=100, nullable=false)
	private String nome;
	
	@NotNull
	private Double valor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_produto", referencedColumnName="codigo")
	private Categoria categoria;
	
	public Produto() {
		
	}

	public Produto(Long codigo) {
		this.codigo = codigo;
	}

	public Produto(Long codigo, String nome, Double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}
}
