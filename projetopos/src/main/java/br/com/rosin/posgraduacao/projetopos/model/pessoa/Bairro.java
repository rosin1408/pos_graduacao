package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="pessoa_bairro")
public @Data class Bairro implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer codigo;
	String nome;
	
	@ManyToOne
	@JoinColumn(name="codigo_cidade")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name="codigo_endereco")
	private Endereco endereco;
	
	public Bairro() {
	}
	
	public Bairro(Integer codigo) {
		this.codigo = codigo;
	}
}
