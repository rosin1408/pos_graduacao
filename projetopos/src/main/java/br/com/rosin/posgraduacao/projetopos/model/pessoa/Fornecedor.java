package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.rosin.posgraduacao.projetopos.model.financeiro.ContaPagar;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Roberto
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="pessoa_fornecedor")
@EqualsAndHashCode(callSuper=true)
public @Data class Fornecedor extends Pessoa implements Serializable {
	
	private String cnpj;
	
	@Column(name="inscricao_estadual")
	private String incricaoEstadual;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@OneToMany(mappedBy="fornecedor")
	private List<ContaPagar> contasPagar;
	
	public Fornecedor() {
	}
	
	public Fornecedor(Integer codigo) {
		setCodigo(codigo);
	}
}
