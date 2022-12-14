package br.edu.infnet.ecommerce.resources.dto;

public class ProdutoDTO {
	private Integer codigo;
	private String titulo;
	//private Integer quantidade;
	private Double valorUnitario;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
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
		return "ProdutoDTO [codigo=" + codigo + "]";
	}	
	
}
