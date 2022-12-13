package br.edu.infnet.appemprestimo.model.exceptions;

public class QuantidadeExemplaresZeradoNegativoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public QuantidadeExemplaresZeradoNegativoException(String mensagem) {
		super(mensagem);
	}
}
