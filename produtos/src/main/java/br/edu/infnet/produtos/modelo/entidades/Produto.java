package br.edu.infnet.produtos.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private String titulo;
	private Double valorUnitario;
	
	public Produto() {		
	}
		
	public Produto(Long codigo, String titulo, Double valorUnitario) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.valorUnitario = valorUnitario;
	}


	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", titulo=" + titulo + ", valorUnitario=" + valorUnitario + "]";
	}
	
	
}
