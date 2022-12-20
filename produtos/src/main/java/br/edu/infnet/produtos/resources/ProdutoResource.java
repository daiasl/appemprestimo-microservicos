package br.edu.infnet.produtos.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.produtos.modelo.entidades.Produto;
import br.edu.infnet.produtos.modelo.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	private static Logger log = LoggerFactory.getLogger(ProdutoResource.class);
			
	@Autowired
	private ProdutoService produtoService;
	private ResponseEntity<List<Produto>> retorno;
	
	@Operation(
	        summary = "Lista os produtos cadastrados no sistema.",
	        description = "Este endpoint tem por objetivo listar todos os produtos cadastrados no sistema."
	        		+ "Estes devem estar previamente cadastrados no banco de dados microservicosdb."
	    )
	@GetMapping
	public ResponseEntity<List<Produto>> getProdutos(){
		log.info("Chamada a api de produtos.");
					
		try {
			retorno = ResponseEntity.ok(produtoService.getAll());
		} catch (Exception e) {
			log.error("Erro ao obter os produtos.", e);
		}
		return retorno;
	}
}
