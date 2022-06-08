package com.salesianostriana.dam.proyectofinal.controladores;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.servicios.PalaServicio;



@Controller
public class PalaController {

	private PalaServicio palaServicio;
	
	public PalaController(PalaServicio servicio) {
		this.palaServicio= servicio;
	}
	
	
	@GetMapping({"private/list"})
	public String listarPalas(Model model) {
		model.addAttribute("lista", palaServicio.findAll());
		return "productos";
	}
	
	@GetMapping("admin/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pala", new Pala());
		return "formPala";
	}
	
	@PostMapping("admin/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("pala") Pala p) {
		palaServicio.save(p);
		return "redirect:/private/list";
	}
	
	@GetMapping("admin/editar/{idPala}")
	public String mostrarFormularioEdicion(@PathVariable("idPala") long id, Model model) {
		Optional<Pala> pEditar = palaServicio.findById(id);
		if (pEditar != null) {
			model.addAttribute("pala", pEditar.get());
			return "formPala";
		} else {
			return "redirect:/private/list";
		}
	}
	
	@PostMapping("admin/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pala") Pala p) {
		palaServicio.edit(p);
		return "redirect:/private/list";
	}
	
	@GetMapping("admin/borrar/{idPala}")
	public String borrar(@PathVariable("idPala") long id) {
		palaServicio.deleteById(id);
		return "redirect:/private/list";
	}
	
	@GetMapping("private/buscar")
	public String buscar(Model model, @RequestParam String nombre) {
		model.addAttribute("lista", palaServicio.buscarPorNombre(nombre));
		return "productos";
	}
	
	/*
	@ModelAttribute("PrecioPalaDescuento")
		public double PrecioPalaDescuento() {
		return palaServicio.precioDiaLiquidacion();
	}
	*/
}
