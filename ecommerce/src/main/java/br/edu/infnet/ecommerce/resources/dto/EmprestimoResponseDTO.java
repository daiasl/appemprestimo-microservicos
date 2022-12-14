package br.edu.infnet.ecommerce.resources.dto;

import java.util.List;

public class EmprestimoResponseDTO {

	private SolicitanteDTO solicitante;
	private List<ProdutoDTO> produtos;
	
	public EmprestimoResponseDTO() {
	}	
	public EmprestimoResponseDTO(SolicitanteDTO solicitante, List<ProdutoDTO> produtos) {
		super();
		this.solicitante = solicitante;
		this.produtos = produtos;
	}
	public SolicitanteDTO getSolicitante() {
		return solicitante;
	}
	public List<ProdutoDTO> getProduto() {
		return produtos;
	}
	
}
