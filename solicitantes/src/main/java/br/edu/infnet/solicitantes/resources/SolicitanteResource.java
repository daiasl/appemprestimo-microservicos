package br.edu.infnet.solicitantes.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.solicitantes.modelo.entidades.Solicitante;
import br.edu.infnet.solicitantes.modelo.services.SolicitanteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteResource {
	private static Logger log = LoggerFactory.getLogger(SolicitanteResource.class); 
	
	@Autowired
	private SolicitanteService solicitanteService;
	
	@Operation(
	        summary = "Lista o solicitante cadastrado no sistema.",
	        description = "Este endpoint tem por objetivo listar o solicitante cadastrado no sistema de acordo com o código."
	        		+ "Este deve estar previamente cadastrado no banco de dados microservicosdb."
	    )
	@GetMapping("/{codigo}")
	public Solicitante getSolicitante(@PathVariable Long codigo) {
		log.info("Chamada a api de solicitantes com código {}", codigo);
		return solicitanteService.getByCodigo(codigo);
	}
	
	
}

