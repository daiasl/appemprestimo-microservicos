package br.edu.infnet.appemprestimo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Emprestimo;
import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Produto;
import br.edu.infnet.appemprestimo.model.domain.Solicitante;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.exceptions.EmprestimoSemProdutoException;
import br.edu.infnet.appemprestimo.model.exceptions.SolicitanteNuloException;
import br.edu.infnet.appemprestimo.model.service.EmprestimoService;

@Component
@Order(6)
public class EmprestimoTeste implements ApplicationRunner {
	
	@Autowired
	private EmprestimoService emprestimoService;

	@Override
	public void run(ApplicationArguments args) {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);
								
			Solicitante sol = new Solicitante();
			sol.setId(1);
			
			Set<Produto> produtos = new HashSet<Produto>();
			Livro livro = new Livro();
			livro.setId(1);			
			livro.setAnoPublicacao(2020);
			produtos.add(livro);
			Livro livro2 = new Livro();
			livro2.setId(2);
			livro2.setAnoPublicacao(2021);
			produtos.add(livro2);
			Livro livro3 = new Livro();
			livro3.setId(3);
			livro3.setAnoPublicacao(2022);
			produtos.add(livro3);
	
			Emprestimo emp = new Emprestimo(sol, produtos);
			emp.setDataDevolucao(LocalDateTime.of(2022, 9, 21, 21, 26));
			emprestimoService.incluir(emp);
		
		} catch (SolicitanteNuloException | EmprestimoSemProdutoException e) {
			System.out.println("[ERROR - Emprestimo ] " + e.getMessage());
		}
		
	}

}
