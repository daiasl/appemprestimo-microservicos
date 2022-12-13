package br.edu.infnet.ecommerce.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.ecommerce.resources.dto.EmprestimoDTO;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {

	@PostMapping
	public void efetuaEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
		System.out.println(emprestimoDTO);
	}
	
}
