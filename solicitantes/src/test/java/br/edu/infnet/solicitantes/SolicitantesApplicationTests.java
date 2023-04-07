package br.edu.infnet.solicitantes;

import br.edu.infnet.solicitantes.modelo.entidades.Solicitante;
import br.edu.infnet.solicitantes.modelo.repository.SolicitanteRepository;
import br.edu.infnet.solicitantes.modelo.services.SolicitanteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolicitantesApplicationTests {

	@Mock
	SolicitanteRepository repository;
	SolicitanteService service;
		
	@BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.service = new SolicitanteService(repository);
    }
	
	@Test
	void findById(){
		
		Solicitante sol = new Solicitante(99L,"Solicitante Teste","sol@sol.com.br","rua x");
		Mockito.when(repository.findById(99L)).thenReturn(Optional.ofNullable(sol.toSolicitante()));
		
		Solicitante solRetornado=service.getByCodigo(99L);
        
		assertEquals(sol.getNome(),solRetornado.getNome());
		assertEquals(sol.getEmail(),solRetornado.getEmail());
		assertEquals(sol.getEndereco(),solRetornado.getEndereco());			
	}

}
