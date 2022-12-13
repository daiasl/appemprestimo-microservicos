package br.edu.infnet.appemprestimo.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.appemprestimo.interfaces.IPrinter;

@Entity
@Table(name="TUsuario")
public class Usuario implements IPrinter{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	@OneToMany
	@JoinColumn(name="idUsuario")
	private List<Solicitante> solicitantes;
	@OneToMany
	@JoinColumn(name="idUsuario")
	private List<Produto> produtos;
	@OneToMany
	@JoinColumn(name="idUsuario")
	private List<Emprestimo> emprestimos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Solicitante> getSolicitantes() {
		return solicitantes;
	}
	public void setSolicitantes(List<Solicitante> solicitantes) {
		this.solicitantes = solicitantes;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {		
		return "Usuário: " + nome + ";" + email + ";" + senha;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	@Override
	public void impressao() {
		System.out.println("#usuario");
		System.out.println(this);		
	}	
	
}
