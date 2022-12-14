package br.edu.infnet.ecommerce.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.ecommerce.resources.dto.ProdutoDTO;

@FeignClient("produto")
public interface ProdutoClient {

	@GetMapping("/produtos")
	ResponseEntity<List<ProdutoDTO>> getProdutos();
}
