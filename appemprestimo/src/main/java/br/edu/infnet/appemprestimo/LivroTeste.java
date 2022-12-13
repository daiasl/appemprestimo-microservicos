package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.LivroService;

@Component
@Order(3)
public class LivroTeste implements ApplicationRunner {
	@Autowired
	private LivroService livroService;

	@Override
	public void run(ApplicationArguments args) {

		Usuario usuario = new Usuario();
		usuario.setId(1);
				
		//987-5-01-30451-3;1;2;2022;Kate Quinn;A Rede de Alice;2;978850304513;3;10;
		//987-65-5564-024-3;1;1;2020;Daiana Garbin;A vida perfeita não existe;3;9786555640243;2;2;

		try {
			Livro livro = new Livro();			
			livro.setIsbn("987-85-508-1500-8");
			livro.setVolume(1);
			livro.setEdicao(1);
			livro.setAnoPublicacao(2020);
			livro.setNomeAutor("Robert C. Martin");
			livro.setTitulo("Desenvolvimento de Software Ágil");
			livro.setEstante(1);
			livro.setCodigoBarras("9788550815008");
			livro.setQtdDisponiveis(5);
			livro.setQtdExemplares(6);
			livro.setUsuario(usuario);
			
			livroService.incluir(livro);			
			
		} catch (Exception e) {
			System.out.println("[ERROR - Livro ] " + e.getMessage());		
		}

	}

}
