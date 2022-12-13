package br.edu.infnet.appemprestimo.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appemprestimo.model.domain.MaterialDigital;

@Repository
public interface MaterialDigitalRepository extends CrudRepository<MaterialDigital, Integer>{
	@Query("from MaterialDigital m where m.usuario.id = :idUsuario")
	Collection<MaterialDigital> findAll(Integer idUsuario);
}
