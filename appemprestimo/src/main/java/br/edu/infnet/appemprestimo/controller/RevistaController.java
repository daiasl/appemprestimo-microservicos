package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Revista;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.RevistaService;

@Controller
public class RevistaController {
	@Autowired
	private RevistaService revistaService;
	private String mensagem;
	private String tipo;
		
	@GetMapping(value= "/Revista/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario){
		model.addAttribute("listagemRevista",revistaService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		return "/Revista/lista";
	}	
	@GetMapping(value= "/Revista")
	public String telaCadastro(){				
		return "/Revista/cadastro";
	}

	@PostMapping(value= "/Revista/Incluir")
	public String incluir(Revista revista, @SessionAttribute("user") Usuario usuario){	
		revista.setUsuario(usuario);
		revistaService.incluir(revista);	
		mensagem="Inclusão da revista " + revista.getTitulo() + " realizada com sucesso!";
		tipo="alert-success";
		return "redirect:/";
	}
	@GetMapping(value="/Revista/{id}/Excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			revistaService.excluir(id);
			mensagem="Exclusão da revista " + id + " realizada com sucesso!";
			tipo="alert-success";
		} catch (Exception e) {
			mensagem="Impossível realizar a exclusão da revista " + id + "!";
			tipo="alert-danger";
		}		
		return "redirect:/Revista/lista";
	}
}
