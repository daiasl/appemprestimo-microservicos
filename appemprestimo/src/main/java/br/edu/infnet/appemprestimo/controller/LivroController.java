package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.LivroService;

@Controller
public class LivroController {				
	@Autowired
	private LivroService livroService;
	private String mensagem;
	private String tipo;
	
	@GetMapping(value= "/Livro/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario){
		model.addAttribute("listagem",livroService.obterLista(usuario));	
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		return "/Livro/lista";
	}
	
	@GetMapping(value= "/Livro")
	public String telaCadastro(){				
		return "/Livro/cadastro";
	}

	@PostMapping(value= "/Livro/Incluir")
	public String incluir(Livro livro, @SessionAttribute("user") Usuario usuario){		
		livro.setUsuario(usuario);
		livroService.incluir(livro);
		mensagem="Inclusão do livro " + livro.getTitulo() + " realizada com sucesso!";
		tipo="alert-success";
		return "redirect:/";
	}	
		
	@GetMapping(value="/Livro/{id}/Excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			livroService.excluir(id);
			mensagem="Exclusão do livro " + id + " realizada com sucesso!";
			tipo="alert-success";
		} catch (Exception e) {
			mensagem="Impossível realizar a exclusão do livro " + id + "!";
			tipo="alert-danger";
		}
		return "redirect:/Livro/lista";
	}
}

