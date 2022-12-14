package br.edu.infnet.solicitantes.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long codigo;
	private String nome;
	private String email;
	private String endereco;
	
	public Solicitante() {		
	}

	public Solicitante(Long codigo, String nome, String email, String endereco) {
		super();		
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Solicitante [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + "]";
	}
	
	
}
