package br.edu.infnet.solicitantes.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.solicitantes.modelo.entidades.Solicitante;

@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante, Long>{

}
