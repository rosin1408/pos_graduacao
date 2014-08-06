package br.edu.utfpr.aulaVraptor.model;

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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
public @Data class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	
	@NotNull
    private Integer numeroDocumento;
	
	@NotNull
	@Column(name="data_pedido")
    private LocalDate dataPedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_cliente", referencedColumnName="codigo") 
    private Cliente cliente;
	
	@NotNull
	@OneToMany(mappedBy="pedido")
	private List<ItensPedido> itensPedido;

    public Pedido() {
    }

	public Pedido(Long codigo) {
		this.codigo = codigo;
	}

	public Pedido(Long codigo, Integer numeroDocumento, LocalDate dataPedido, Cliente cliente) {
		this.codigo = codigo;
		this.numeroDocumento = numeroDocumento;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
	}
}
