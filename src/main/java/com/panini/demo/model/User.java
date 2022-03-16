package com.panini.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	
	private String username;
	private String password;
	private String email;
	private int tokens;
	private String addressofliving;
	private String addressofselling;
	
	//@OneToMany(mappedBy = "users")
	//private List<Album> albums;
	
	
	public User () {
		
	}
	
	
	
	public User(Long id, String nombre, String apellido, String correo, int tokens) {
		this.userid = id;
		this.username = nombre;
		this.password = apellido;
		this.email = correo;
		this.tokens = tokens;
		
	}
	
	public Long getId() {
		return userid;
	}
	
	public void setId(Long id) {
		this.userid = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String nombre) {
		this.username = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String apellido) {
		this.password = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String correo) {
		this.email = correo;
	}

	public String getAddressofliving() {
		return addressofliving;
	}

	public void setAddressofliving(String addressofliving) {
		this.addressofliving = addressofliving;
	}

	public String getAddressofselling() {
		return addressofselling;
	}

	public void setAddressofselling(String addressofselling) {
		this.addressofselling = addressofselling;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

//	public List<Album> getAlbums() {
//		return albums;
//	}
//
//	public void setAlbums(List<Album> albums) {
//		this.albums = albums;
//	}
//
//	public Album addAlbum(Album newalbum) {
//		getAlbums().add(newalbum);
//		newalbum.setUser(this);
//		
//		return newalbum;
//	}
	
}