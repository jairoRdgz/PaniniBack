package com.panini.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "albums")
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long albumid;
	
	private String albumName;
	private int laminasNumber;
	
	@ManyToOne
	private User user;


	@OneToMany(mappedBy = "album")
	@JsonIgnoreProperties("album")
	private List<Lamina> laminas;
	
	public int getLaminasnumber() {
		return laminasNumber;
	}

	public void setLaminasnumber(int laminasnumber) {
		this.laminasNumber = laminasnumber;
	}

	public Album() {
		
	}
	
	public Album(Long id, String name) {
		this.albumid = id;
		this.albumName = name;
	}

	public Long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Long id) {
		this.albumid = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String name) {
		this.albumName = name;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Lamina> getLaminas() {
		return laminas;
	}

	public void setLaminas(List<Lamina> laminas) {
		this.laminas = laminas;
	}
	
	public Lamina addLamina(Lamina lamina) {
		getLaminas().add(lamina);
		lamina.setAlbum(this);
		return lamina;
	}
	
}
