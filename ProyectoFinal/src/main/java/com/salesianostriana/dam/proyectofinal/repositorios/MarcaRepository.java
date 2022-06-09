package com.salesianostriana.dam.proyectofinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Marca;


public interface MarcaRepository 
	extends JpaRepository<Marca, Long> {

	}
