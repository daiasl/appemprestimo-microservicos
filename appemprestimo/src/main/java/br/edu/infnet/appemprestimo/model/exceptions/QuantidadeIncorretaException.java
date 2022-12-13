package br.edu.infnet.appemprestimo.model.exceptions;

public class QuantidadeIncorretaException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantidadeIncorretaException(String mensagem) {
		super(mensagem);
	}
}
