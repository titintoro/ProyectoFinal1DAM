package com.salesianostriana.dam.pruebaproyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pala {

	@Id @GeneratedValue
	private long idPala;
	
	private String nombre;
	
	private  String marca;
	
	private double precio;
	
	private LocalDate fechaLiquidacion;
	
	private String imagen;
	
	
	
}
