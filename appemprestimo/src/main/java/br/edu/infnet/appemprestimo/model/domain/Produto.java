package br.edu.infnet.appemprestimo.model.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.appemprestimo.interfaces.IPrinter;
import br.edu.infnet.appemprestimo.model.exceptions.AnoPublicacaoInvalidoException;
import br.edu.infnet.appemprestimo.model.exceptions.QuantidadeExemplaresZeradoNegativoException;
import br.edu.infnet.appemprestimo.model.exceptions.QuantidadeIncorretaException;

@Entity
@Table(name="TProduto")
@Inheritance(strategy = InheritanceType.JOINED) 
public abstract class Produto implements IPrinter{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private int estante;
	private String codigoBarras;
	protected int qtdExemplares;
	private int qtdDisponiveis;
	@ManyToMany(mappedBy = "produtos")
	private List<Emprestimo> emprestimos;
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	public abstract int CalculaQtdProdutoEmprestado() throws AnoPublicacaoInvalidoException, QuantidadeExemplaresZeradoNegativoException, QuantidadeIncorretaException;
			
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEstante() {
		return estante;
	}

	public void setEstante(int estante) {
		this.estante = estante;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public int getQtdExemplares() {
		return qtdExemplares;
	}

	public void setQtdExemplares(int qtdExemplares) {
		this.qtdExemplares = qtdExemplares;
	}

	public int getQtdDisponiveis() {
		return qtdDisponiveis;
	}

	public void setQtdDisponiveis(int qtdDisponiveis) {
		this.qtdDisponiveis = qtdDisponiveis;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	@Override
	public String toString() {		
		return titulo + ";" + estante + ";" + codigoBarras + ";" + qtdExemplares + ";" + qtdDisponiveis;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//if (getClass() != obj.getClass())
		//	return false;
		Produto other = (Produto) obj;
		return Objects.equals(titulo, other.titulo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
}
