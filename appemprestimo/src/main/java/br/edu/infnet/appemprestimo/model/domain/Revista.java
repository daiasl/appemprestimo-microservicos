package br.edu.infnet.appemprestimo.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appemprestimo.model.exceptions.QuantidadeIncorretaException;

@Entity
@Table(name="TRevista")
public class Revista extends Produto {
	private String issn;	
	private int edicao;	
	private int ano;
	
	@Override
	public int CalculaQtdProdutoEmprestado() throws QuantidadeIncorretaException {		
		System.out.println("Calcula qtd produtos emprestados - revista:");
		int qtdRevista = (ano==2022) ? 1 : 0;		
		
		if (getQtdDisponiveis() < 1 || getQtdDisponiveis() > 50 ) {
			throw new QuantidadeIncorretaException("A quantidade de revistas disponíveis não pode ser menor que 1 ou maior que 50.");
		}		
		return qtdExemplares - getQtdDisponiveis() + qtdRevista;
	}
		
	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {		
		return "Revista:" + issn + ";" + edicao + ";" + ano + ";" + super.toString();
	}

	@Override
	public void impressao() {
		System.out.println("#revista");
		System.out.println(this);
	}
}
