package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="pessoa_telefone")
public @Data class Telefone implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String numero;
	
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;
	
	@ManyToOne
	@JoinColumn(name="codigo_contato")
	private Contato contato;
	
	public Telefone() {
	}

	public Telefone(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Telefone(Integer codigo, String numero, TipoTelefone tipo, Contato contato) {
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.contato = contato;
	}

}
