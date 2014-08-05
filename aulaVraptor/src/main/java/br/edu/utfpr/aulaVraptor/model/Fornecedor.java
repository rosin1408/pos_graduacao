package br.edu.utfpr.aulaVraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.Email;

@Entity
public @Data class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	
	@NotNull
	@Size(min=3, max=100)
    private String nome;
	
	@NotNull
	@Size(min=3, max=20)
    private String cnpj;
	
	@NotNull
	@Size(min=3, max=15)
    private String telefone;
	
	@Email
    private String email;
	

    public Fornecedor() {
    }

	public Fornecedor(Long codigo) {
		this.codigo = codigo;
	}

	public Fornecedor(Long codigo, String nome, String cnpj, String telefone, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
	}
}
