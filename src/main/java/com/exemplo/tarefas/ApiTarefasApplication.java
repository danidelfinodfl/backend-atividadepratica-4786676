package com.exemplo.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTarefasApplication.class, args);
		System.out.println("API de Tarefas iniciada com sucesso!");
		System.out.println("Acesse: http://localhost:8080/api/tarefas");
	}
}