package com.salesianostriana.dam.pruebaproyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
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

	private long idPala;
	
	private String nombre;
	
	private  String marca;
	
	private double precio;
	
	private LocalDate fechaLiquidacion;
	
	
	
}
