package br.edu.infnet.solicitantes.modelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.solicitantes.modelo.entidades.Solicitante;
import br.edu.infnet.solicitantes.modelo.repository.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	public SolicitanteService(SolicitanteRepository repository) {
        this.solicitanteRepository = repository;
    }
	
	public Solicitante getByCodigo(Long codigo) {
		Solicitante solicitante = solicitanteRepository.findById(codigo).get();		
		return solicitante;
	}

	
	
	
}	
