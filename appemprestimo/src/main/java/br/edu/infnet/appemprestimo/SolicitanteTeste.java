package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.Solicitante;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.exceptions.CpfInvalidoException;
import br.edu.infnet.appemprestimo.model.service.SolicitanteService;

@Component
@Order(2)
public class SolicitanteTeste implements ApplicationRunner {
	@Autowired
	private SolicitanteService solicitanteService;
		
	@Override
	public void run(ApplicationArguments args)  {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
				
//		Ana de Souza Pereira;22222222222;
//		Maria Helena da Silva;33333333333;
		try {
			Solicitante solicitante = new Solicitante("João da Silva","11111111111");
			solicitante.setUsuario(usuario);
			
			solicitanteService.incluir(solicitante);
			
		} catch (CpfInvalidoException e) {
			System.out.println("[ERROR - Solicitante ] " + e.getMessage());
		}	
		
	}

}
