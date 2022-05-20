package com.salesianostriana.dam.proyectofinal.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Pala;

public interface PalaRepository

extends JpaRepository<Pala, Long>{

	List<Pala> findByNombreContainsIgnoreCaseOrMarcaContainsIgnoreCase(String nombre, String apellidos);
	
	 Optional<Pala> findById(Long id);
	
}
