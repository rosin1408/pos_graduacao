package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="pessoa_contato")
public @Data class Contato implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String email;
	private String site;
	
	@ManyToOne
	@JoinColumn(name="codigo_pessoa")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy="contato")
	private List<Telefone> telefones;
	
	public Contato() {
	}

	public Contato(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public Contato(Integer codigo, String email, String site) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.site = site;
	}
}
