package br.com.agenda_inteligente.agenda_inteligente_database.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
class HomeController {

    @GetMapping
    String hello() {
	return "Ola, mundo";
    }
}
