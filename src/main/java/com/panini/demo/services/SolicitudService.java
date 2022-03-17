package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Solicitud;
import com.panini.demo.repository.SolicitudRepository;

@Service
public class SolicitudService {

	@Autowired
	private SolicitudRepository solicitudRepository;
	
	public Solicitud create (Solicitud solicitud) {
		return solicitudRepository.save(solicitud);
	}
	
	public List<Solicitud> getAllSolicitudes (){
		return solicitudRepository.findAll();
	}
	
	public Optional<Solicitud> findById (Long id){
		return solicitudRepository.findById(id);
	}
	
	public void delete (Solicitud solicitud) {
		solicitudRepository.delete(solicitud);
	}
	
	public void update (Solicitud solicitud) {
		Solicitud nuevo = solicitudRepository.getById(solicitud.getSolicitudid());
		nuevo.setInfo(solicitud.getInfo());
		nuevo.setTitle(solicitud.getTitle());
		
		solicitudRepository.save(nuevo);
		
	}
}
