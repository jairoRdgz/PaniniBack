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
	private String section;
	private String category;
	private String range;
	private double categoryprice;
	
	
	private double rangeprice;
	private double price;
	
	public Precio() {
		
	}

	public Precio(Long precioid, String number, String lamina, String section, String category, String range,
			double categoryprice, double rangeprice, double price) {
		super();
		this.precioid = precioid;
		this.number = number;
		this.lamina = lamina;
		this.section = section;
		this.category = category;
		this.range = range;
		this.categoryprice = categoryprice;
		this.rangeprice = rangeprice;
		this.price = price;
	}

	public Long getPrecioid() {
		return precioid;
	}

	public void setPrecioid(Long precioid) {
		this.precioid = precioid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLamina() {
		return lamina;
	}

	public void setLamina(String lamina) {
		this.lamina = lamina;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public double getCategoryprice() {
		return categoryprice;
	}

	public void setCategoryprice(double categoryprice) {
		this.categoryprice = categoryprice;
	}

	public double getRangeprice() {
		return rangeprice;
	}

	public void setRangeprice(double rangeprice) {
		this.rangeprice = rangeprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
