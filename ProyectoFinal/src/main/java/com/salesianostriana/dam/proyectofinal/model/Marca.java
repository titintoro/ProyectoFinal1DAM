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
public class Marca {

	@Id @GeneratedValue
	private long idMarca;
	
	private String nombre;
	private String ceo;
	
	@ManyToOne
	private Pala pala;
}
