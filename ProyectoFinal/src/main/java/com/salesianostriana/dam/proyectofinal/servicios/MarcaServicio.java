package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Marca;
import com.salesianostriana.dam.proyectofinal.repositorios.MarcaRepository;

@Service
public class MarcaServicio {
	
	
		private MarcaRepository marcaRepo;
		
		public MarcaServicio(MarcaRepository repo) {
			this.marcaRepo = repo;
		}
		

		public Marca add(Marca c) { 
			return marcaRepo.save(c); }
		

		public Marca edit(Marca c) {
			return marcaRepo.save(c); }


		public void delete(Marca c) { 
			marcaRepo.delete(c); }
		

		public void delete(long id) { 
			marcaRepo.deleteById(id); }
		

		public List<Marca> findAll() { 
			return marcaRepo.findAll(); }
		
		
		public Marca findById(long id) {
			return marcaRepo.findById(id).orElse(null);
		}
		
		
		
	}
