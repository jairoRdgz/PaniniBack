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
	private Long precioid;
	
	private String number;
	private String lamina;
	private String category;
	private double price;
	
	public Precio() {
		
	}
	
	public Precio(Long pracioid, String name, String lamina, String category, double precio) {
		this.precioid = pracioid;
		this.number = name;
		this.lamina = lamina;
		this.category = category;
		this.price = precio;
	}

	public Long getPrecioid() {
		return precioid;
	}

	public void setPrecioid(Long pracioid) {
		this.precioid = pracioid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String name) {
		this.number = name;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double precio) {
		this.price = precio;
	}
	
	
	
}
