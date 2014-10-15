/**
 * 
 */
package br.com.rosin.posgraduacao.projetopos.model.financeiro;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.rosin.posgraduacao.projetopos.model.pessoa.Usuario;
import lombok.Data;

/**
 * @author Roberto
 * @data 06/10/2014
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public @Data abstract class Titulo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="codigo_documento_origem")
	private String codigoDocumentoOrigem;
	
	@Column(name="origem_documento")
	private String origemDocumento;
	private LocalDate data;
	private Boolean quitado;
	
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario usuario;
	
	@ManyToOne
	private FormaPagamento formaPagamento;
	
	@ManyToOne
	private TipoJuro tipoJuro;
	
	public Titulo() {
	}

	public Titulo(Integer codigo) {
		this.codigo = codigo;
	}
}
