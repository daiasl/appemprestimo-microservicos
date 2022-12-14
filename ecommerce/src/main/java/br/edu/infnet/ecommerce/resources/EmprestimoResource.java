package br.edu.infnet.ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.ecommerce.clients.ProdutoClient;
import br.edu.infnet.ecommerce.resources.dto.EmprestimoDTO;
import br.edu.infnet.ecommerce.resources.dto.EmprestimoResponseDTO;
import br.edu.infnet.ecommerce.resources.dto.ProdutoDTO;
import br.edu.infnet.ecommerce.resources.dto.SolicitanteDTO;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${solicitante.endpoint.url}")
	private String solicitanteAPIUrl;
	
	@Autowired
	private ProdutoClient produtoClient;
		
	@PostMapping
	public EmprestimoResponseDTO efetuaEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
	
		SolicitanteDTO solicitanteDTO = restTemplate.getForObject(solicitanteAPIUrl + 
						emprestimoDTO.getSolicitanteid(), SolicitanteDTO.class);
		
		System.out.println(solicitanteDTO);

		ResponseEntity<List<ProdutoDTO>> produtos = produtoClient.getProdutos();
		System.out.println(produtos.getBody());
		
		System.out.println(emprestimoDTO);	
		
		return new EmprestimoResponseDTO(solicitanteDTO, produtos.getBody());
		
	}	
	
}
