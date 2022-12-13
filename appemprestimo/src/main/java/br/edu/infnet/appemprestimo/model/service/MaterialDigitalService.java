package br.edu.infnet.appemprestimo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appemprestimo.model.domain.MaterialDigital;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.repository.MaterialDigitalRepository;
import br.edu.infnet.appemprestimo.model.test.AppImpressao;

@Service
public class MaterialDigitalService {
	
	@Autowired
	private MaterialDigitalRepository materialDigitalRepository;	

	public void incluir(MaterialDigital materialDigital) {			
		materialDigitalRepository.save(materialDigital);		
		AppImpressao.relatorio("Inclusão do Material Digital "+ materialDigital.getTitulo() +" realizada com sucesso. ", materialDigital);
	}
	public Collection<MaterialDigital> obterLista() {
		return (Collection<MaterialDigital>) materialDigitalRepository.findAll();
	}
	public Collection<MaterialDigital> obterLista(Usuario usuario) {
		return (Collection<MaterialDigital>) materialDigitalRepository.findAll(usuario.getId());
	}
	public void excluir(Integer id){
		materialDigitalRepository.deleteById(id);
	}
}
