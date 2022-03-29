package com.panini.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "laminas")
public class Lamina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long laminaid;
	
	private String img;
	private int cuantity;
	private boolean filter;
	private String title;
	private int page;
	
	//private Solicitud solicitud;
	
	@ManyToOne
	@JoinColumn(name = "albumid")
	@JsonIgnoreProperties("laminas")
	private Album album;
	
	public Lamina() {
		
	}

	public Lamina(Long laminaid,String title, String img, int cuantity, boolean filter) {
		this.laminaid = laminaid;
		this.img = img;
		this.cuantity = cuantity;
		this.filter = filter;
		this.title = title;
	}

	public Long getLaminaid() {
		return laminaid;
	}

	public void setLaminaid(Long laminaid) {
		this.laminaid = laminaid;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public boolean isFilter() {
		return filter;
	}

	public void setFilter(boolean filter) {
		this.filter = filter;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
