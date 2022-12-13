package br.edu.infnet.appemprestimo.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.appemprestimo.interfaces.IPrinter;
import br.edu.infnet.appemprestimo.model.exceptions.CpfInvalidoException;

@Entity
@Table(name="TSolicitante")
public class Solicitante implements IPrinter{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public Solicitante() {
	}
	
	public Solicitante(String nome, String cpf) throws CpfInvalidoException {	
		if(cpf == null) {
			throw new CpfInvalidoException ("Não é possível aceitar cpf nulo.");
		}
		if(cpf.isEmpty()) {
			throw new CpfInvalidoException ("Não é possível cpf sem preenchimento.");
		}
		
		this.cpf=cpf;	
		this.nome=nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {		
		return "Solicitante: " + nome + ";" + cpf;
	}

	@Override
	public void impressao() {
		System.out.println("#solicitante");
		System.out.println(this);		
	}	
	
}
