package com.salesianostriana.dam.proyectofinal.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.servicios.PalaServicio;
import com.salesianostriana.dam.proyectofinal.servicios.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private PalaServicio palaServicio;
	
    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, PalaServicio palaServicio) {
        this.shoppingCartService = shoppingCartService;
        this.palaServicio = palaServicio;
    }
    
    @GetMapping ("/carrito")
    public String showCarrito (Model model) {
    	
    	if (model.addAttribute("products",shoppingCartService.getProductsInCart()) == null)
    		return "redirect:/";
    	return "cart";
    }

    @GetMapping ("/productoACarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    	
    	shoppingCartService.addPala(palaServicio.findById(id));
    	    		 	
    	return "redirect:/carrito";
    }
    
    @GetMapping("/borrarProducto/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        
    	shoppingCartService.borrarPala(palaServicio.findById(id));
        return "redirect:/carrito";
    }
    
    @ModelAttribute("total_carrito")
    public Double totalCarrito () {
    	
    	Map <Pala,Integer> carrito=shoppingCartService.getPalasEnCarrito();
    	double total=0.0;
    	if (carrito !=null) {
        	for (Pala p: carrito.keySet()) {
        		total+=p.getPrecio()*carrito.get(p);
        	}
        	return total;
    	}
    	
    	return 0.0;
    }
}
