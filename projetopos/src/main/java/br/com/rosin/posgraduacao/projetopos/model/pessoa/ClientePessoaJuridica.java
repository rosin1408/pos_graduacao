package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;

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
@Table(name="pessoa_cliente_pessoa_juridica")
@EqualsAndHashCode(callSuper=true)
public @Data class ClientePessoaJuridica extends Cliente implements Serializable {
	
	private String cnpj;
	
	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	public ClientePessoaJuridica() {
	}

	public ClientePessoaJuridica(Integer codigo) {
		setCodigo(codigo);
	}
}
