package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Solicitante;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.SolicitanteService;

@Controller
public class SolicitanteController {
	@Autowired
	private SolicitanteService solicitanteService;
	private String mensagem;
	private String tipo;
	
	@GetMapping(value= "/Solicitante/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario){
		model.addAttribute("listagem",solicitanteService.obterLista(usuario));	
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		return "/Solicitante/lista";
	}
	
	@GetMapping(value= "/Solicitante")
	public String telaCadastro(){				
		return "/Solicitante/cadastro";
	}

	@PostMapping(value= "/Solicitante/Incluir")
	public String incluir(Solicitante solicitante, @SessionAttribute("user") Usuario usuario){			
		solicitante.setUsuario(usuario);		
		solicitanteService.incluir(solicitante);
		mensagem="Inclusão do solicitante " + solicitante.getNome() + " realizada com sucesso!";
		tipo="alert-success";
		return "redirect:/Solicitante/lista";
	}
	
	@GetMapping(value="/Solicitante/{id}/Excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			solicitanteService.excluir(id);
			mensagem="Exclusão do solicitante " + id + " realizada com sucesso!";
			tipo="alert-success";
		} catch (Exception e) {
			mensagem="Impossível realizar a exclusão do solicitante " + id + "!";
			tipo="alert-danger";
		}		
		return "redirect:/Solicitante/lista";
	}
	
	
}
