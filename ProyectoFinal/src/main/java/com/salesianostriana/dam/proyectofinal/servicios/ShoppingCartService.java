 package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.repositorios.PalaRepository;



@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartService {

	private PalaRepository palaRepository;
	private Pala pala;
	private Map<Pala, Integer> palas = new HashMap <> ();
	
	@Autowired
	private VentaServicio vs;
	
	
	@Autowired
	public ShoppingCartService (PalaRepository palaRepository) {
		this.palaRepository=palaRepository;
	}

	
	public void addPala (Pala p) {
		if (palas.containsKey(p)) {
			palas.replace(p, palas.get(p)+1);
		}else {
			palas.put(p, 1);
		}
	}
	

	public void borrarPala (Pala p) {
        if (palas.containsKey(p)) {
            if (palas.get(p) > 1)
            	palas.replace(p, palas.get(p) - 1);
            else if (palas.get(p) == 1) {
            	palas.remove(p);
            }
        }
	}
	

    public Map<Pala, Integer> getPalasEnCarrito() {
        return Collections.unmodifiableMap(palas);
    }

    public void finalizarCompra() {
    	Venta v = new Venta();
    	vs.save(v);
    	double totalVenta=0;
    	
    	LineaVenta lvn;
    	
    	for (Map.Entry<Pala, Integer> lineaVenta : palas.entrySet()){
    		
			lvn= LineaVenta
					.builder()
					.pala(lineaVenta.getKey())
					.cantidad(lineaVenta.getValue())
					.subtotal(lineaVenta.getValue()*lineaVenta.getKey().getPrecio())
					.build();
			totalVenta+=(lineaVenta.getValue()*lineaVenta.getKey().getPrecio());
			lvn.agregarAVenta(v);
		}
    	v.setPrecioFinal(totalVenta);
    	vs.save(v);
    	palas.clear();
    	
    }

    
}
