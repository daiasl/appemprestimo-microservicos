package br.edu.infnet.appemprestimo.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appemprestimo.model.domain.Revista;

@Repository
public interface RevistaRepository extends CrudRepository<Revista, Integer>{
	@Query("from Revista r where r.usuario.id = :idUsuario")
	Collection<Revista> findAll(Integer idUsuario);
}
