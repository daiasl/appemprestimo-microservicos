package br.edu.infnet.appemprestimo.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.edu.infnet.appemprestimo.interfaces.IPrinter;

public class AppImpressao {
	
	public static void relatorio (String mensagem, IPrinter printer) {
		System.out.println(mensagem);
		printer.impressao();
	}
	public static void main(String[] args) {
		String dir = "C:/Temp/";
		String arq = "Emprestimos.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha =leitura.readLine(); 
				while(linha !=null) {
					System.out.println(linha);
					linha =leitura.readLine();
				}				
				
				leitura.close();
				fileReader.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] O arquivo não existe!!!"); 
			} catch (IOException e) {
				System.out.println("[ERRO] Problema ao fechar o arquivo!!!");
			}	
		} finally {
			System.out.println("Terminou!");
		}
		
	}
	
}
