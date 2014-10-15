/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Roberto
 * @data 06/10/2014
 */
@Entity
@Table(name="financeiro_forma_pagamento")
public @Data class FormaPagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private Boolean ativo;
	
	public FormaPagamento() {
	}

	public FormaPagamento(Integer codigo, String nome, Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
	}
}
