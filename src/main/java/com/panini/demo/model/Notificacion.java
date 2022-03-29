package com.panini.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Notifications")
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long notifyid;
	
	private String title;
	private String info;
	private boolean solicitud;
	private int cuantity;
	private int number;
	private int tokens;
	
	@ManyToOne
	private User user;
	
	public Notificacion() {
		
	}

	public Notificacion(Long notifyid, String title, String info, boolean solicitud, int cuantity, int number,int tokens) {
		this.notifyid = notifyid;
		this.title = title;
		this.info = info;
		this.solicitud = solicitud;
		this.cuantity = cuantity;
		this.number = number;
		this.tokens = tokens;
	}

	public Long getNotifyid() {
		return notifyid;
	}

	public void setNotifyid(Long notifyid) {
		this.notifyid = notifyid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isSolicitud() {
		return solicitud;
	}

	public void setSolicitud(boolean solicitud) {
		this.solicitud = solicitud;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
