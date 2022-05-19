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
	private String type;
	private int cuantity;
	private String lamina;
	private int tokens;
	private String notificationid;
	
	@ManyToOne
	private User user;
	
	public Notificacion() {
		
	}

	public Notificacion(Long notifyid, String title, String info, String solicitud, int cuantity, String lamina,int tokens) {
		this.notifyid = notifyid;
		this.title = title;
		this.info = info;
		this.type = solicitud;
		this.cuantity = cuantity;
		this.lamina = lamina;
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

	public String getType() {
		return type;
	}

	public void setType(String solicitud) {
		this.type = solicitud;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public String getLamina() {
		return lamina;
	}

	public void setLamina(String lamina) {
		this.lamina = lamina;
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

	public String getNotificationid() {
		return notificationid;
	}

	public void setNotificationid(String notificationid) {
		this.notificationid = notificationid;
	}
	
	
}
