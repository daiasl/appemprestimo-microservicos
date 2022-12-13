package br.edu.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.ProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	private String mensagem;
	private String tipo;
	
	@GetMapping(value= "/Produto/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario){
		model.addAttribute("listagem",produtoService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		model.addAttribute("tipo", tipo);
		return "/Produto/lista";
	}
	
	@GetMapping(value="/Produto/{id}/Excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			produtoService.excluir(id);	
			mensagem="Exclusão do produto " + id + " realizada com sucesso!";
			tipo="alert-success";
		} catch (Exception e) {
			mensagem="Impossível realizar a exclusão do produto " + id + "!";
			tipo="alert-danger";
		}		
		return "redirect:/Produto/lista";
	}
}