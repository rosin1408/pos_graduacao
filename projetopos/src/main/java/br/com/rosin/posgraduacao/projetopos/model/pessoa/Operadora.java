package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 13/10/2014
 */
@Entity
@Table(name="pessoa_operadora")
public @Data class Operadora {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	
	public Operadora() {
	}
	
	public Operadora(Integer codigo) {
		this.codigo = codigo;
	}

	public Operadora(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

}
