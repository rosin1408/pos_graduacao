/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.rosin.posgraduacao.projetopos.model.pessoa.Cliente;
import br.com.rosin.posgraduacao.projetopos.model.servico.OrdemServico;
import br.com.rosin.posgraduacao.projetopos.model.venda.PedidoVenda;

/**
 * @author Roberto
 * @data 06/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="financeiro_contas_receber")
@EqualsAndHashCode(callSuper=true)
public @Data class ContaReceber extends Titulo implements Serializable {
	
	@Column(name="data_recebimento")
	private LocalDate dataRecebimento;
	
	@OneToOne(mappedBy="titulo")
	private PedidoVenda pedido;
	
	@OneToOne(mappedBy="titulo")
	private OrdemServico ordem;
	
	@ManyToOne
	@JoinColumn(name="codigo_cliente")
	private Cliente cliente;
	
	public ContaReceber() {
	}
	
	public ContaReceber(Integer codigo) {
		setCodigo(codigo);
	}
	
	public ContaReceber(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
}
