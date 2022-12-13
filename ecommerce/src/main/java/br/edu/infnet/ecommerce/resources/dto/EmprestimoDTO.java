package br.edu.infnet.ecommerce.resources.dto;

import java.util.List;

public class EmprestimoDTO {
	
	private Integer solicitanteid;
	private List<ProdutoDTO> produtos;
	public Integer getEmprestimoid() {
		return emprestimoid;
	}
	public void setEmprestimoid(Integer emprestimoid) {
		this.emprestimoid = emprestimoid;
	}
	public Integer getSolicitanteid() {
		return solicitanteid;
	}
	public void setSolicitanteid(Integer solicitanteid) {
		this.solicitanteid = solicitanteid;
	}
	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	private Integer emprestimoid;
	@Override
	public String toString() {
		return "EmprestimoDTO [emprestimoid=" + emprestimoid + ", solicitanteid=" + solicitanteid + ", produtos="
				+ produtos + "]";
	}
		
}
