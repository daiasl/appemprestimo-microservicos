package br.edu.infnet.appemprestimo.model.exceptions;

public class EmprestimoSemProdutoException extends Exception {

	private static final long serialVersionUID = 1L;
	public EmprestimoSemProdutoException(String mensagem) {
		super(mensagem);
	}

}
