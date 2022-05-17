package com.salesianostriana.dam.proyectofinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "logIn.html";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "logIn.html";
    }
    
    @GetMapping("/inicio")
	public String inicio() {
		return "index";
	}

}
