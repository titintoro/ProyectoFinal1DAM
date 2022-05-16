package com.salesianostriana.dam.proyectofinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {
	
	
	@GetMapping("/")
	public String welcome() {
		return "logIn";
	}


	@GetMapping("/error")
	public String error() {
		return "error";
	}
	

}
