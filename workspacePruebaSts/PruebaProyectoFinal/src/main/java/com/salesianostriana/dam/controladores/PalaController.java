package com.salesianostriana.dam.controladores;

import java.util.Optional;

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

	private PalaServicio palaServicio;
	
	public PalaController(PalaServicio servicio) {
		this.palaServicio= servicio;
	}
	
	@GetMapping({"/", "/list"})
	public String listarPalas(Model model) {
		model.addAttribute("lista", palaServicio.findAll());
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pala", new Pala());
		return "formulario";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("pala") Pala p) {
		palaServicio.save(p);
		return "redirect:/list";
	}
	
	@GetMapping("editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		Optional<Pala> pEditar = palaServicio.findById(id);
		if (pEditar != null) {
			model.addAttribute("pala", pEditar);
			return "formulario";
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
