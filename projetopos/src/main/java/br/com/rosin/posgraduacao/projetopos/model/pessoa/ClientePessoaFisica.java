/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Roberto
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="pessoa_cliente_pessoa_fisica")
@EqualsAndHashCode(callSuper=true)
public @Data class ClientePessoaFisica extends Cliente implements Serializable {
	
	private String cpf;
	private String rg;
	
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;
	
	public ClientePessoaFisica() {
	}

	public ClientePessoaFisica(Integer codigo) {
		setCodigo(codigo);
	}
}
