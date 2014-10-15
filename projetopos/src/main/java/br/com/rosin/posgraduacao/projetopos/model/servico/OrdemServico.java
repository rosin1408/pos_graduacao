/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.servico;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rosin.posgraduacao.projetopos.model.financeiro.ContaReceber;
import lombok.Data;

/**
 * @author Roberto
 * @data 07/10/2014
 */
@Entity
@Table(name="servico_ordem")
public @Data class OrdemServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private LocalDate data;
	
	@Column(name="data_execucao")
	private LocalDate dataExecucao;
	
	@Column(name="data_entrega")
	private LocalDate dataEntrega;
	
	@OneToMany(mappedBy="ordem")
	private List<ServicoOrdem> servicos;
	
	@OneToOne
	@JoinColumn(name="codigo_titulo")
	private ContaReceber titulo;
}
