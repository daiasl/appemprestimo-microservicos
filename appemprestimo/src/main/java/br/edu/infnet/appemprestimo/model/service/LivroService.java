package br.edu.infnet.appemprestimo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.model.domain.Livro;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.repository.LivroRepository;
import br.edu.infnet.appemprestimo.model.test.AppImpressao;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void incluir(Livro livro) {			
		livroRepository.save(livro);	
		AppImpressao.relatorio("Inclusão do Livro "+ livro.getTitulo() +" realizada com sucesso. ", livro);
	}
	public Collection<Livro> obterLista() {
		return (Collection<Livro>) livroRepository.findAll();
	}
	public Collection<Livro> obterLista(Usuario usuario) {
		return (Collection<Livro>) livroRepository.findAll(usuario.getId());
	}
	public void excluir(Integer id){
		livroRepository.deleteById(id);
	}
}
