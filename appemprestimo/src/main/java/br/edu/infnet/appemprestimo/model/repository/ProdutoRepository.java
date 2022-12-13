package br.edu.infnet.appemprestimo.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appemprestimo.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	@Query("from Produto l where l.usuario.id = :idUsuario")
	Collection<Produto> findAll(Integer idUsuario);
}
