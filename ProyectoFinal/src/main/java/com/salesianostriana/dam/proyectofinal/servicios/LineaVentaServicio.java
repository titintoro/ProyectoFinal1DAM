package com.salesianostriana.dam.proyectofinal.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.model.Pala;
import com.salesianostriana.dam.proyectofinal.repositorios.LineaVentaRepository;
import com.salesianostriana.dam.proyectofinal.servicio.base.ServicioBaseImpl;



@Service
public class LineaVentaServicio 

extends ServicioBaseImpl<LineaVenta, Long, LineaVentaRepository>{

	private Pala p;
	
	//Esta es mi segunda regla de negocio, aplicar un descuento que surja cuando compras dos palas del mismo modelo, la segunda vale 1 €
	//Método que calcula un descuento que se da si te llevas dos unidades iguales, la segunda vale 1 euro.
	
	public void descuento2ud(LineaVenta l) {
		
		double precioFinalConDescuento=0;
		
		//Gracias a este cálculo adivinamos si el numero de palas es par por lo que cada 2 palas aplicariamos el descuento
		
		/*
		if ((l.getCantidad()%2)==0) {
			
			l.setDescuento((l.getPrecio()/2)+(l.getCantidad()/2));
			
			precioFinalConDescuento=l.getPrecio()-l.getDescuento();
			
			l.setPrecio(precioFinalConDescuento);
			
		} else if ((((l.getCantidad()+1)%2)==0)&&l.getCantidad()!=1) {
			
			l.setPrecio((l.getPrecio()/2)+(l.getCantidad()/2));
			
		}*/
		
	}
	
}
