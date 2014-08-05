package br.edu.utfpr.aulaVraptor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
public @Data class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	
	@NotNull
	@Size(max=100, min=3)
    private String nome;
	
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;

    public Categoria() {
    }
    
	public Categoria(Long codigo) {
		this.codigo = codigo;
	}
	
	public Categoria(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
}
