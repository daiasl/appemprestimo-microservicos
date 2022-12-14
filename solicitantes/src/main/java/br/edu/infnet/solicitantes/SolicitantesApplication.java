package br.edu.infnet.solicitantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SolicitantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolicitantesApplication.class, args);
		
		
		
	}

}
