package br.com.bscarpari.todolist.controller;

/* Importações/dependências */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador responsável por receber as requisições HTTP.
 * 
 * Este controlador é utilizado para construir uma API REST.
 */
@RestController
@RequestMapping("/first-route") // http://localhost:8080/first-route
public class FirstController {

    /**
     * Retorna uma saudação "Hello World!".
     * 
     * Este método é executado quando uma requisição HTTP é feita.
     * Os tipos de requisição suportados são: GET, POST, PUT, DELETE e PATCH.
     * 
     * - GET: Utilizado para buscar informações.
     * - POST: Utilizado para criar informações.
     * - PUT: Utilizado para atualizar informações.
     * - DELETE: Utilizado para deletar informações.
     * - PATCH: Utilizado para atualizar parcialmente informações.
     * 
     * @return a saudação "Hello World!"
     */
    @GetMapping("/first-method")
    public String hello() {
        return "Hello World!";
    }
}
