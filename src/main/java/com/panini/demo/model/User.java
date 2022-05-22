package com.panini.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "users")
public class User {
	
	@Id
	private String userid;
	
	private String firebaseid;
	
	private String username;
	private String password;
	private String email;
	private int tokens;
	private String addressofliving;
	private String addressofselling;
	
	
	@OneToMany(mappedBy="user")
	private List<Album> albums;
	
	@OneToMany(mappedBy="user")
	private List<Notificacion> notificaciones;
	
	
	public User () {
		this.tokens = 0;
	}

	
	public User(String id, String nombre, String apellido, String correo) {
		this.userid = id;
		this.username = nombre;
		this.password = apellido;
		this.email = correo;
		this.tokens = 0;
		
	}
	
	public String getFirebaseid() {
		return firebaseid;
	}



	public void setFirebaseid(String firebaseid) {
		this.firebaseid = firebaseid;
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

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album newalbum) {
		getAlbums().add(newalbum);
		newalbum.setUser(this);
		
		return newalbum;
	}

	public Notificacion addNotificacion(Notificacion newnoti) {
		getNotificaciones().add(newnoti);
		newnoti.setUser(this);
		
		return newnoti;
	}


	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}



	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
}