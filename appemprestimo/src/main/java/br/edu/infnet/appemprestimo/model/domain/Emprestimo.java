package br.edu.infnet.appemprestimo.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.infnet.appemprestimo.interfaces.IPrinter;
import br.edu.infnet.appemprestimo.model.exceptions.EmprestimoSemProdutoException;
import br.edu.infnet.appemprestimo.model.exceptions.SolicitanteNuloException;

@Entity
@Table(name="TEmprestimo")
public class Emprestimo implements IPrinter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataEmprestimo;		
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataDevolucao;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idSolicitante")
	private Solicitante solicitante;
	@ManyToMany(cascade = CascadeType.DETACH)
	private Set<Produto> produtos;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;	
	
	public Emprestimo() {
		this.dataEmprestimo = LocalDateTime.now();
	}
	public Emprestimo(Solicitante solicitante, Set<Produto> produtos) throws SolicitanteNuloException, EmprestimoSemProdutoException {
		this();
		
		if(solicitante == null){
			throw new SolicitanteNuloException("Não é permitido realizar empréstimo sem solicitante.");
		}
		//if (produtos == null) {
		//	throw new EmprestimoSemProdutoException("Impossível realizar um empréstimo sem uma listagem de produtos associados!");
		//}		
		//if (produtos.size()<1) {
		//	throw new EmprestimoSemProdutoException("Impossível realizar um empréstimo com menos de um produto!");
		//}
		this.solicitante = solicitante;
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {		
		return "Empréstimo: " + dataEmprestimo + ";" + dataDevolucao + ";" + solicitante + ";" + produtos.size();
	}

	@Override
	public void impressao() {
		System.out.println("#emprestimo");
		System.out.println(this);		
	}
	
	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}
	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
