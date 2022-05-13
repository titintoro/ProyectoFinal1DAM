package com.salesianostriana.dam.pruebaproyectofinal.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyectofinal.model.Pala;
import com.salesianostriana.dam.pruebaproyectofinal.servicios.PalaServicio;


//Clase basada en AlumnoController del proyecto 13_Crud, consultar dudas ahi

@Controller
public class PalaController {

	@Autowired
	private PalaServicio palaServicio;
	
	
	@GetMapping({"/", "/list"})
	public String listarPalas(Model model) {
		model.addAttribute("lista", palaServicio.findAll());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pala", new Pala());
		return "formPala";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("pala") Pala p) {
		palaServicio.save(p);
		return "redirect:/list";
	}
	
	@GetMapping("editar/{idPala}")
	public String mostrarFormularioEdicion(@PathVariable("idPala") long id, Model model) {
		Optional<Pala> pEditar = palaServicio.findById(id);
		if (pEditar != null) {
			model.addAttribute("pala", pEditar);
			return "formPala";
		} else {
			return "redirect:/list";
		}
	}
	
	//Si peta cambiar redirect:/list por redirect:/
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pala") Pala p) {
		palaServicio.edit(p);
		return "redirect:/list";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		palaServicio.deleteById(id);
		return "redirect:/list";
	}
	
	
	
}

