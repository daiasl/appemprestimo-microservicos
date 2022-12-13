package br.edu.infnet.appemprestimo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.model.domain.Emprestimo;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.repository.EmprestimoRepository;
import br.edu.infnet.appemprestimo.model.test.AppImpressao;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public void incluir(Emprestimo emprestimo) {			
		emprestimoRepository.save(emprestimo);
		AppImpressao.relatorio("Empréstimo realizado com sucesso.", emprestimo);
	}
	public Collection<Emprestimo> obterLista() {
		return (Collection<Emprestimo>) emprestimoRepository.findAll(); 
	}	
	public Collection<Emprestimo> obterLista(Usuario usuario) {
		return (Collection<Emprestimo>) emprestimoRepository.findAll(usuario.getId());
	}
	public void excluir(Integer id){
		emprestimoRepository.deleteById(id);
	}
}
