package br.edu.infnet.solicitantes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.solicitantes.modelo.entidades.Solicitante;
import br.edu.infnet.solicitantes.modelo.services.SolicitanteService;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteResource {
	
	@Autowired
	private SolicitanteService solicitanteService;
	
	@GetMapping("/{codigo}")
	public Solicitante getSolicitante(@PathVariable Long codigo) {
		return solicitanteService.getByCodigo(codigo);
	}
	
	
}

