package com.panini.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "solicitudes")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long solicitudid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate modifieddate;
	
	private String title;
	private String info;

	public Solicitud() {
		
	}

	public Solicitud(Long solicitudid, LocalDate modifieddate, String title, String info) {		super();
		this.solicitudid = solicitudid;
		this.modifieddate = modifieddate;
		this.title = title;
		this.info = info;
	}

	public Long getSolicitudid() {
		return solicitudid;
	}

	public void setSolicitudid(Long solicitudid) {
		this.solicitudid = solicitudid;
	}

	public LocalDate getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
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
	
	
}
