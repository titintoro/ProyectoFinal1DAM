package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.repositorios.PalaRepository;

/**
 * El carrito se implementa con un Map y un Bean de sesión
 * De manera general:
 * - Un Bean es solo una "receta" para crear instancias de una clase 
 * de acuerdo con dicha definición, por tanto, dicha receta 
 * se puede usar para múltiples instancias a lo largo del ciclo de vida 
 * de la aplicación.
 * Spring permite configurar en la definición de los Beans el scope 
 * (o ámbbito de vida de los objetos creados a partir de dicha definición).
 * - En este caso, el contenedor de Spring creará una nueva instancia 
 * del objeto definido por el Bean 
 * para cada una de las sesiones HTTP y entregará esa misma 
 * instancia cada vez que reciba una petición dentro de la misma sesión.
 * - Por otro lado, idealmente esta clase debería implementar 
 * a su interfaz correspondiente y aquí solo se implementarían los métodos
 * de dicha interfaz
 * 
 * @author Ángel N
 * */

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartService {

	private PalaRepository palaRepository;
	
	private Map<Pala, Integer> palas = new HashMap <> ();
	
	@Autowired
	
	public ShoppingCartService (PalaRepository palaRepository) {
		this.palaRepository=palaRepository;
	}
	
	/**
	 * Si el producto ya está en el map (en el carrito), solo se incrementará en uno la cantidad, una unidad más
	 * Si el producto no está en el mapa, significa que no se ha comprado nada de él en este momento, por lo que se añade con cantidad 1
	 * 
	 * @param pala
	 * */
	
	public void addPala (Pala p) {
		if (palas.containsKey(p)) {
			palas.replace(p, palas.get(p)+1);//Ya programamos como "mayores" y podemos poner algún número directamente en el código
		}else {
			palas.put(p, 1);
		}
	}
	
	/**
	 * Método que elimina un producto del carrito.
	 * Si en el carrito la cantidad de dicho producto es más de uno baja la cantidad en una unidad y si es uno elimina el producto entero
	 * @param producto
	 * */
	
	public void borrarPala (Pala p) {
        if (palas.containsKey(p)) {
            if (palas.get(p) > 1)
            	palas.replace(p, palas.get(p) - 1);
            else if (palas.get(p) == 1) {
            	palas.remove(p);
            }
        }
	}
	
    /**
     * @return unmodifiable Copia del carrito no modificable, solo vista
     */
	

    public Map<Pala, Integer> getPalasEnCarrito() {
        return Collections.unmodifiableMap(palas);
    }
	
    /**
     * Se debería tener un método para revisar si hay suficiente 
     * cantidad de productos en el stock 
     * (si se gestiona el stock) no desarrollada en este ejemplo,
     * puesto que no se gestiona ni el stock ni cantidad de producto 
     * es atributo de la clase POJO Producto,
     * esto debería estar gestionado en línea de pedido, pedido, etc.
     * Se podría tener una excepción propia 
     * (del estilo NotEnoughProductsInStockException) y gestionarlo
     */


    
}
