package com.salesianostriana.dam.proyectofinal.model;



import java.time.LocalDate;
import java.util.List;

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
public class Marca {

	@Id @GeneratedValue
	private long idMarca;
	
	private String nombre;
	private String ceo;
}
