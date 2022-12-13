package br.edu.infnet.appemprestimo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.model.domain.Produto;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}
	public Collection<Produto> obterLista(Usuario usuario) {
		return (Collection<Produto>) produtoRepository.findAll(usuario.getId());
	}
	public void excluir(Integer id){
		produtoRepository.deleteById(id);
	}
	
}
