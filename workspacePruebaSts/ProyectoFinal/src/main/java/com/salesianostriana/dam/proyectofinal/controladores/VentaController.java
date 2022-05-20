package com.salesianostriana.dam.proyectofinal.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.servicios.ShoppingCartService;
import com.salesianostriana.dam.proyectofinal.servicios.VentaServicio;


@Controller
public class VentaController {
	
	@Autowired
    private ShoppingCartService shoppingCartService;
	
	private VentaServicio vs;
	
	
	@PostMapping("/nuevaVenta/submit")
	public String procesarFormulario(@ModelAttribute("venta") Venta v) {
		vs.save(v);
		return "redirect:/private/list";
	}}
