package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.io.Serializable;
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
 * 
 * @author Roberto
 * @data 13/10/2014
 */
@SuppressWarnings("serial")
@Entity
@Table(name="pessoa_cidade")
public @Data class Cidade implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nome;
	
	@Column(name="codigo_ibge")
	private Long codigoIbge;
	
	@ManyToOne
	@JoinColumn(name="codigo_estado")
	private Estado estado;
	
	@OneToMany(mappedBy="cidade")
	private List<Bairro> bairros;
	
	public Cidade() {
	}
	
	public Cidade(Integer codigo) {
		this.codigo = codigo;
	}
}
