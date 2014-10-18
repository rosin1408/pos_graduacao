/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.produto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Roberto
 * @data 10/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="produto_categoria")
public @Data class CategoriaProduto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nome;
	
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;
	
	public CategoriaProduto() {
	}

	public CategoriaProduto(Integer codigo) {
		this.codigo = codigo;
	}

	public CategoriaProduto(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
}
