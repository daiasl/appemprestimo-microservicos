package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Revista;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.RevistaService;

@Component
@Order(5)
public class RevistaTeste implements ApplicationRunner {
	@Autowired
	private RevistaService revistaService;
	
	@Override
	public void run(ApplicationArguments args) {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
//		2357-7886;138;2021;Revista Wine - Entrevista com Julia Cavil;5;9772357788009;3;20;
//		456-7890;1;2022;História da Humanidade;5;;1;1;
				
		try {
			Revista revista=new Revista();
			revista.setIssn("1980393-1");
			revista.setEdicao(6);
			revista.setAno(2011);
			revista.setTitulo(".Net Magazine");
			revista.setEstante(5);
			revista.setCodigoBarras("");
			revista.setQtdDisponiveis(20);
			revista.setQtdExemplares(20);	
			revista.setUsuario(usuario);
			System.out.println("Calcula qtd. produto emprestado: " + revista.CalculaQtdProdutoEmprestado());
			revistaService.incluir(revista);
		} catch (Exception e) {
			System.out.println("[ERROR - Revista] " + e.getMessage());
		}	
		
	}

}
