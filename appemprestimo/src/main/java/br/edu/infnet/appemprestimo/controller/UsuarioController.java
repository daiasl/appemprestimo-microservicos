package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value= "/Usuario/lista")
	public String telaLista(Model model){
		model.addAttribute("listagem", usuarioService.obterLista());		
		return "Usuario/lista";
	}
	
	@GetMapping(value= "/Usuario")
	public String telaCadastro(){				
		return "/Usuario/cadastro";
	}
	
	@PostMapping(value= "/Usuario/Incluir")
	public String incluir(Usuario usuario){				
		usuarioService.incluir(usuario);
		System.out.println(">>>>Incluído: "+usuario.getEmail());
		return "redirect:/";
	}
	
	@GetMapping(value="/Usuario/{email}/Excluir")
	public String excluir(@PathVariable String email) {
		usuarioService.excluir(email);
		System.out.println(">>>>Excluído: "+email);
		return "redirect:/Usuario/lista";
	}
	
	
}
