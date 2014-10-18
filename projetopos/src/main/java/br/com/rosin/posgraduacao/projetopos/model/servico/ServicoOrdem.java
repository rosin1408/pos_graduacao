/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.servico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Roberto
 * @data 07/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "servico_servico_ordem")
public @Data class ServicoOrdem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "valor_unitario")
	private Double valorUnitario;
	private Double quantidade;
	
	@ManyToOne
	@JoinColumn(name="codigo_ordem")
	private OrdemServico ordem;
	
	@ManyToOne
	@JoinColumn(name="codigo_servico")
	private Servico servico;

	public ServicoOrdem() {
	}

	public ServicoOrdem(Integer codigo) {
		this.codigo = codigo;
	}

	public ServicoOrdem(Integer codigo, Double valorUnitario, Double quantidade) {
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}
}
