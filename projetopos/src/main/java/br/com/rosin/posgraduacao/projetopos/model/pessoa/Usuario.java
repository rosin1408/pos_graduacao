package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Roberto
 * @data 13/10/2014
 */
@Entity
@Table(name="pessoa_usuario")
@EqualsAndHashCode(callSuper=true)
public @Data class Usuario extends Pessoa {
	
	private String usuario;
	private String senha;
	
	public Usuario() {
	}
	
	public Usuario(Integer codigo) {
		setCodigo(codigo);
	}
	
	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
}
