package com.salesianostriana.dam.pruebaproyectofinal.servicio.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServicioBaseImpl<T, ID, R extends JpaRepository<T, ID>> implements ServicioBase {

	@Autowired
	protected R repositorio;
	
	
	public List<T> findAll() {
		return repositorio.findAll();
	}

	public Optional<T> findById(ID id) {
		return repositorio.findById(id);
	}

	public T save(T a) {
		return repositorio.save(a);
	}
	
	

	public List<T> saveAll(List<T> list) {
		return repositorio.saveAll(list);
	}

	public T edit(T a) {
		return save(a);
	}

	public void delete(T a) {
		repositorio.delete(a);
	}

	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}

}
