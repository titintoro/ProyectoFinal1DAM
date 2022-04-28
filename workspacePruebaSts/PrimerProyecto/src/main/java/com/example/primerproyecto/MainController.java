package com.example.primerproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("nombre", "titin");
		return "index";
	}
}
