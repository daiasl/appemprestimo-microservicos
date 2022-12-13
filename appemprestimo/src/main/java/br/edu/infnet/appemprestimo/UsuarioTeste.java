package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioTeste implements ApplicationRunner {
	@Autowired
	private UsuarioService usuarioService;
	private Usuario usuario;
	
	@Override
	public void run(ApplicationArguments args)  {

//		João da Silva;joao@joao.com;123;
//		Ana de Souza Pereira;ana@ana.com;123;
//		Maria Helena da Silva;helena@helena.com;123;

		usuario = new Usuario();
		usuario.setEmail("admin@admin.com");
		usuario.setNome("Administrador");
		usuario.setSenha("123");		
		usuarioService.incluir(usuario);
		
	}

}
