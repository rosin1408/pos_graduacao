/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.servico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Roberto
 * @data 07/10/2014
 */
@Entity
@Table(name="servico_servico")
public @Data class Servico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="valor_cobrado")
	private Double valorCobrado;
	private String nome;
	private String descricao;
}
