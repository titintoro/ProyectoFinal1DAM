package com.salesianostriana.dam.operacionesycondiciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Con dependencia Lombok no haría falta constructor con todos los parámetros y getters and setters
//toString, etc.

@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {
	
	private String nombre;
	private String descripcion;
	private float precio;
	private int numeroVotos;
	private float porcentajeSatisfaccion;
	
	public Producto(String nombre, String descripcion, float precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(String nombre, String descripcion, float precio, int numeroVotos, float porcentajeSatisfaccion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.numeroVotos = numeroVotos;
		this.porcentajeSatisfaccion = porcentajeSatisfaccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public void setNumeroVotos(int numeroVotos) {
		this.numeroVotos = numeroVotos;
	}

	public float getPorcentajeSatisfaccion() {
		return porcentajeSatisfaccion;
	}

	public void setPorcentajeSatisfaccion(float porcentajeSatisfaccion) {
		this.porcentajeSatisfaccion = porcentajeSatisfaccion;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", numeroVotos="
				+ numeroVotos + ", porcentajeSatisfaccion=" + porcentajeSatisfaccion + "]";
	}
	
	
}
