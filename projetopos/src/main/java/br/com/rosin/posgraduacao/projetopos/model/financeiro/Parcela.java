/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
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
 * @author Roberto
 * @data 06/10/2014
 */
@Entity
@Table(name="financeiro_parcela")
public @Data class Parcela {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private Double valor;
	
	@Column(name="data_vencimento")
	private LocalDate dataVencimento;
	private Integer parcela;
	private Boolean quitada;
	private Double desconto;
	private Double acrecimo;
	
	@Column(name="percentual_juro")
	private Double percentualJuro;
	
	@Column(name="valor_juro")
	private Double valorJuro;
	
	@Column(name="data_pagamento")
	private LocalDate dataPagamento;
	
	@Column(name="valor_pago")
	private Double valorPago;
	private String observacao;
	
	@Column(name="nosso_numero")
	private String nossoNumero;
	
	@ManyToOne
	@JoinColumn(name="codigo_titulo")
	private Titulo titulo;
	
	@OneToMany(mappedBy="parcela")
	private List<Caixa> caixas;
	
	public Parcela() {
	}
	
	public Parcela(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
