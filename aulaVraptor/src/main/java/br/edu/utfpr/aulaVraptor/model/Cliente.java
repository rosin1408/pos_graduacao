package br.edu.utfpr.aulaVraptor.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
public @Data class Cliente{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;

	@NotNull
	@Column(nullable=false, length=100)
	private String nome;
	
	//@NotNull
    private String cpf;
	
	//@NotNull
    private String telefone;
	
	//@NotNull
    private String email;
	
	@OneToMany(mappedBy="cliente")
	private List<Venda> vendas;
	
	public Cliente(Long codigo) {
		this.codigo = codigo;
	}
	
	public Cliente() {
	}

	public Cliente(Long codigo, String nome, String cpf, String telefone,
			String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}
}
