/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.financeiro;

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
 * @data 06/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="financeiro_caixa_detalhe")
public @Data class CaixaDetalhe implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="valor_pago")
	private Double valorPago;
	
	@ManyToOne
	@JoinColumn(name="codigo_tipo_documento", referencedColumnName="codigo")
	private TipoDocumento tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name="codigo_caixa", referencedColumnName="codigo")
	private Caixa caixa;
	
	public CaixaDetalhe() {
	}
	
	public CaixaDetalhe(Integer codigo) {
		this.codigo = codigo;
	}
	
	public CaixaDetalhe(Integer codigo, Double valorPago) {
		this.codigo = codigo;
		this.valorPago = valorPago;
	}
}
