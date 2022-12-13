package br.edu.infnet.appemprestimo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.model.domain.Revista;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.repository.RevistaRepository;
import br.edu.infnet.appemprestimo.model.test.AppImpressao;

@Service
public class RevistaService {
	@Autowired
	private RevistaRepository revistaRepository;	
	
	public void incluir(Revista revista) {			
		revistaRepository.save(revista);	
		AppImpressao.relatorio("Inclusão da revista "+ revista.getTitulo() +" realizada com sucesso. ", revista);
	}
	public Collection<Revista> obterLista() {
		return (Collection<Revista>) revistaRepository.findAll();
	}
	public Collection<Revista> obterLista(Usuario usuario) {
		return (Collection<Revista>) revistaRepository.findAll(usuario.getId());
	}
	public void excluir(Integer id){
		revistaRepository.deleteById(id);
	}
}
