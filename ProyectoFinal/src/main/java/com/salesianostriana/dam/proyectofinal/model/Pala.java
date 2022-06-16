package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pala {

	@Id @GeneratedValue
	private long idPala;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	private int unidades;
	
	private double precio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaLiquidacion;
	
	private String imagen;

	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="pala", fetch = FetchType.EAGER, cascade=javax.persistence.CascadeType.REMOVE, orphanRemoval = true)
	private List<LineaVenta> listaPalas;
	
}
