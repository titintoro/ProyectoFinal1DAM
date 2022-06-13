package com.salesianostriana.dam.proyectofinal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Marca;
import com.salesianostriana.dam.proyectofinal.servicios.MarcaServicio;

@Controller
public class MarcaController {

	private MarcaServicio marcaServ;
	
	public MarcaController(MarcaServicio servicio) {
		this.marcaServ = servicio;
	}
	

	@GetMapping({"admin/listamarcas"})
	public String listarMarcas(Model model) {
		model.addAttribute("marcas", marcaServ.findAll());
		return "marcas";
	}
	

	@GetMapping("admin/nuevamarca")
	public String mostrarFormulario(Model model) {

		model.addAttribute("marca", new Marca());
		return "formMarca";
	}
	

	@PostMapping("admin/nuevamarca/submit")
	public String procesarFormularioMarca(@ModelAttribute("marca") Marca m) {
		marcaServ.add(m);
		return "redirect:/admin/listamarcas";
	}
	
	

	@GetMapping("admin/editarmarca/{idMarca}")
	public String mostrarFormularioEdicionMarca(@PathVariable("idMarca") long id, Model model) {
		
		Marca mEditar = marcaServ.findById(id);
		
		if (mEditar != null) {
			model.addAttribute("marca", mEditar);
			return "formMarca";
		} else {
			return "redirect:/admin/listamarcas";
		}
		
		
	}
	

	@PostMapping("admin/editarmarca/submit")
	public String procesarFormularioEdicion(@ModelAttribute("Marca") Marca m) {
		marcaServ.edit(m);
		return "redirect:/admin/listamarcas";
	}
	

	@GetMapping("admin/borrarmarca/{idMarca}")
	public String borrar(@PathVariable("idMarca") long id) {
		marcaServ.delete(id);
		return "redirect:/admin/listamarcas";
	}
	
}
	

