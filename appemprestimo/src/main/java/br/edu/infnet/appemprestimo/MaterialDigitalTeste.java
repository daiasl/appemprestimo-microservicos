package br.edu.infnet.appemprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appemprestimo.model.domain.MaterialDigital;
import br.edu.infnet.appemprestimo.model.domain.Usuario;
import br.edu.infnet.appemprestimo.model.service.MaterialDigitalService;

@Component
@Order(4)
public class MaterialDigitalTeste implements ApplicationRunner {
	@Autowired
	private MaterialDigitalService mdService;
	
	@Override
	public void run(ApplicationArguments args) {

		Usuario usuario = new Usuario();
		usuario.setId(1);

//		10.1590/S0100;2008;1;https://doi.org/10.1590/S0100-19652008000300003;As redes cognitivas na ciência da informação brasileira: um estudo nos artigos científicos publicados nos periódicos da área;4;;1;1;
//		10.1590/1413;2022;1;https://doi.org/10.1590/1413-81232022271.22562019;Perspectivas acerca do conceito de saúde mental: análise das produções científicas brasileiras;4;;1;1;
		
		try {
			MaterialDigital md = new MaterialDigital();
			md.setDoi("10.1590/S1415");
			md.setAno(1998);
			md.setVolume(1);
			md.setLinkDoi("https://doi.org/10.1590/S1415-65551998000300009");
			md.setTitulo("Sistemas de Informação no Brasil: uma análise dos artigos científicos dos anos 90");
			md.setEstante(4);
			md.setCodigoBarras("");
			md.setQtdDisponiveis(1);
			md.setQtdExemplares(1);
			md.setUsuario(usuario);
			System.out.println("Calcula qtd. produto emprestado: " + md.CalculaQtdProdutoEmprestado());
			mdService.incluir(md);
		} catch (Exception e) {
			System.out.println("[ERROR - Material Digital] " + e.getMessage());
		}										
					
	}

}
