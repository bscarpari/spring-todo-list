package br.com.bscarpari.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @algumNome -> annotation (função) que vai ser executada pelo Spring
@SpringBootApplication
public class TodolistApplication {

	// Método main para executar a aplicação (principal)
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
