package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Roberto
 * @data 06/10/2014
 */
@Entity
@Table(name="financeiro_caixa")
public @Data class Caixa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private Double valor;
	private LocalDate data;
	
	@Column(name="percentual_juro")
	private Double percentualJuro;
	private Double acrecimos;
	private Double descontos;
	private Boolean parcial;
	
	@Column(name="valor_juro")
	private Double valorJuro;
	
	@Column(name="numero_recibo")
	private String numeroRecibo;
	
	@OneToMany(mappedBy="caixa")
	private List<CaixaDetalhe> detalhes;
	
	@ManyToOne
	private Parcela parcela;
	
	public Caixa() {
	}

	public Caixa(Integer codigo) {
		this.codigo = codigo;
	}
}
