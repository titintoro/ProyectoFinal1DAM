package com.salesianostriana.dam.proyectofinal.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.formbeans.SearchBean;
import com.salesianostriana.dam.proyectofinal.servicios.PalaServicio;


@Controller
public class VentaController {
	@Autowired
	HttpSession session;
	
	@Autowired
	private PalaServicio palaServicio;
	
	@GetMapping({"/", "/list"})
	public String productList(Model model) {
		
		model.addAttribute("productos", palaServicio.findAllProducts());

/*La siguiente línea viene del último método, 
 * que se dedica a buscar, para que este método, 
 * muestre también el listado de productos cuando se han buscado, 
 * añadimos al model el objeto tipo bean de búsqueda cuando se está 
 * buscando algún producto*/
		model.addAttribute("searchForm", new SearchBean());
		return "list";
	}}
