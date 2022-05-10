package com.salesianostriana.dam.pruebaproyectofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineaVenta {

	@Id @GeneratedValue
	private long idLineaVenta;
	
	@ManyToOne
	private Pala pala;
	
	private int cantidad;
	
	private double precio;
	
	private double descuento;
	
	@ManyToOne
	private Venta venta;
	
	public void addToVenta(Venta venta) {
		this.venta = venta;
		venta.getListaPalas().add(this);
	}
	
	public void removeFromVenta(Venta venta) {
		venta.getListaPalas().remove(this);
		this.venta = null;
	}
	
}
