package com.salesianostriana.dam.proyectofinal.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.repositorios.PalaRepository;
import com.salesianostriana.dam.proyectofinal.servicio.base.ServicioBaseImpl;



@Service
public class PalaServicio 
	extends ServicioBaseImpl<Pala, Long, PalaRepository>{
	

	
	/* Esta es una de mis dos reglas de negocio, la pala tiene un atributo llamado fechaLiquidacion,
	 * dicho dia la pala recibira un descuento del 60% ya que lleva mas tiempo en el almacen de lo que el administrador 
	 * quiere, se puede cambiar pero lo he decidido asi, 
	 * al crear la pala se decide dicho atributo. 
	 */
	
	
	public void precioDiaLiquidacion(Pala p){
		
		double precioLiquidacion=0 , descuentoLiquidacion=60, porcentDescuento=100;
		
		if (p.getFechaLiquidacion()==LocalDate.now()){
			precioLiquidacion=p.getPrecio()-((p.getPrecio()*descuentoLiquidacion)/porcentDescuento);
			
			p.setPrecio(precioLiquidacion);
		}
		
	}
	
	
	
	public List<Pala> buscarPorNombre(String cadena) {
		return repositorio.findByNombreContainsIgnoreCaseOrMarcaContainsIgnoreCase(cadena, cadena);
	}
	
	
}
