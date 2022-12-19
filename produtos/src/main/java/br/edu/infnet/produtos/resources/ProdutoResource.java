package br.edu.infnet.produtos.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.produtos.modelo.entidades.Produto;
import br.edu.infnet.produtos.modelo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	private static Logger log = LoggerFactory.getLogger(ProdutoResource.class);
			
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> getProdutos(){
		log.info("Chamada a api de produtos.");
		return produtoService.getAll();
	}
}
