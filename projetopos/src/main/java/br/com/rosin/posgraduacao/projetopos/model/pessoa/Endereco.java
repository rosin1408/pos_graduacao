package br.com.rosin.posgraduacao.projetopos.model.pessoa;

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
@Entity
@Table(name="pessoa_endereco")
public @Data class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String logradouro;
	private String numero;
	private String cep;
	private String referencia;
	
	@ManyToOne
	@JoinColumn(name="codigo_pessoa")
	private Pessoa pessoa;
	
	@OneToOne(mappedBy="endereco")
	private Bairro bairro;
	
	public Endereco() {
	}
	
	public Endereco(Integer codigo) {
		this.codigo = codigo;
	}
}
