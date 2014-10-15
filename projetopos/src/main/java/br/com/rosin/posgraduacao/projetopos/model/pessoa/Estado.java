package br.com.rosin.posgraduacao.projetopos.model.pessoa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pessoa_estado")
public @Data class Estado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String uf;
	
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades;
	
	public Estado() {
	}
	
	public Estado(Integer codigo) {
		this.codigo = codigo;
	}
}
