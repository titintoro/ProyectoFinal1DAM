package com.salesianostriana.dam.proyectofinal.model;

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
	
	private int cantidad;
	
	private double precio;
	
	private double subtotal;
	
	@ManyToOne
	private Venta venta;
	
	public void agregarAVenta(Venta venta) {
		this.venta = venta;
		venta.getListaPalas().add(this);
	}
	
	public void eliminarDeVenta(Venta venta) {
		venta.getListaPalas().remove(this);
		this.venta = null;
	}
	
	
	@ManyToOne
	private Pala pala;
	
}