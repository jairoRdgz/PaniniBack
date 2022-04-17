package com.panini.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "precios")
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})

public class Precio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pracioid;
	
	private String name;
	private String lamina;
	private String category;
	private double precio;
	
	public Precio() {
		
	}
	
	public Precio(Long pracioid, String name, String lamina, String category, double precio) {
		this.pracioid = pracioid;
		this.name = name;
		this.lamina = lamina;
		this.category = category;
		this.precio = precio;
	}

	public Long getPracioid() {
		return pracioid;
	}

	public void setPracioid(Long pracioid) {
		this.pracioid = pracioid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLamina() {
		return lamina;
	}

	public void setLamina(String lamina) {
		this.lamina = lamina;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
