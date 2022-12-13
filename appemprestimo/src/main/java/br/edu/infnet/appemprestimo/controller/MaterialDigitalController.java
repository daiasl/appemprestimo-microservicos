package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.MaterialDigital;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.MaterialDigitalService;

@Controller
public class MaterialDigitalController {
	@Autowired
	private MaterialDigitalService mdService;
	private String mensagem;
	private String tipo;
		
	@GetMapping(value= "/MaterialDigital/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario){
		model.addAttribute("listagemMaterialDigital",mdService.obterLista(usuario));		
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		return "/MaterialDigital/lista";
	}	
	@GetMapping(value= "/MaterialDigital")
	public String telaCadastro(){				
		return "/MaterialDigital/cadastro";
	}

	@PostMapping(value= "/MaterialDigital/Incluir")
	public String incluir(MaterialDigital materialDigital, @SessionAttribute("user") Usuario usuario){				
		materialDigital.setUsuario(usuario);
		mdService.incluir(materialDigital);
		mensagem="Inclusão do material digital " + materialDigital.getTitulo() + " realizada com sucesso!";
		tipo="alert-success";
		return "redirect:/";
	}
	@GetMapping(value="/MaterialDigital/{id}/Excluir")
	public String exclusao(@PathVariable Integer id) {
		try {
			mdService.excluir(id);
			mensagem="Exclusão do material digital " + id + " realizada com sucesso!";
			tipo="alert-success";
		} catch (Exception e) {
			mensagem="Impossível realizar a exclusão do material digital " + id + "!";
			tipo="alert-danger";
		}
		return "redirect:/MaterialDigital/lista";
	}
}

