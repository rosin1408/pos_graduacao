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

@Entity
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	
	@NotNull
    private Integer numeroDocumento;
	
	@NotNull
	@Column(name="data_venda")
    private LocalDate dataVenda;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="codigo_cliente", referencedColumnName="codigo") 
    private Cliente cliente;
	
	@OneToMany(mappedBy="venda")
	private List<VendaProduto> itensVenda;

    public Venda() {
    }

	public Venda(Long codigo) {
		this.codigo = codigo;
	}

	public Venda(Long codigo, Integer numeroDocumento, LocalDate dataVenda, Cliente cliente) {
		this.codigo = codigo;
		this.numeroDocumento = numeroDocumento;
		this.dataVenda = dataVenda;
		this.cliente = cliente;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<VendaProduto> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<VendaProduto> itensVenda) {
		this.itensVenda = itensVenda;
	}
}
