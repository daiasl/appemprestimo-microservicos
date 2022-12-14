package br.edu.infnet.produtos.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.produtos.modelo.entidades.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
