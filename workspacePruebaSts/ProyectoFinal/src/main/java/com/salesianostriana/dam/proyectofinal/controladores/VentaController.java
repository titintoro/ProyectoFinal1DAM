package com.salesianostriana.dam.proyectofinal.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.servicios.ShoppingCartService;


@Controller
public class VentaController {
	
	@Autowired
    private ShoppingCartService shoppingCartService;
	
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
