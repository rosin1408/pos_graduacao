package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 06/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="financeiro_categoria")
public @Data class Categoria implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	
	public Categoria() {
	}

	public Categoria(Integer codigo) {
		this.codigo = codigo;
	}

	public Categoria(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
}
