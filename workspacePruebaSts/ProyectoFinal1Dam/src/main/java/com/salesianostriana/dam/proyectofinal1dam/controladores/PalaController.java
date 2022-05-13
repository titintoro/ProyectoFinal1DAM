package com.salesianostriana.dam.proyectofinal1dam.controladores;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal1dam.model.Pala;
import com.salesianostriana.dam.proyectofinal1dam.servicios.PalaServicio;


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
	
	@GetMapping("/borrar/{idPala}")
	public String borrar(@PathVariable("idPala") long id) {
		palaServicio.deleteById(id);
		return "redirect:/list";
	}
	
	
	
}
