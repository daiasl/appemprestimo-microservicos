package br.edu.infnet.appemprestimo.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appemprestimo.model.exceptions.QuantidadeExemplaresZeradoNegativoException;

@Entity
@Table(name="TMaterialDigital")
public class MaterialDigital extends Produto {
	
	private String doi;	
	private int volume;	
	private int ano;
	private String linkDoi;
		
	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getLinkDoi() {
		return linkDoi;
	}

	public void setLinkDoi(String linkDoi) {
		this.linkDoi = linkDoi;
	}

	@Override
	public String toString() {		
		return "Material Digital:" + doi + ";" + volume + ";" + ano + ";" + linkDoi + ";" + super.toString();
	}

	@Override
	public void impressao() {
		System.out.println("#materialdigital");
		System.out.println(this);		
	}

	@Override
	public int CalculaQtdProdutoEmprestado() throws QuantidadeExemplaresZeradoNegativoException {	
		if (qtdExemplares == 0) {
			throw new QuantidadeExemplaresZeradoNegativoException("A quantidade de exemplares ("+ qtdExemplares +") não pode igual a zero.");
		}
		if (qtdExemplares < 0) {
			throw new QuantidadeExemplaresZeradoNegativoException("A quantidade de exemplares ("+ qtdExemplares +") não pode ter valor negativo.");
		}
		return qtdExemplares - getQtdDisponiveis();
	}
}
