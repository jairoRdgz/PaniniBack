package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Notificacion;
import com.panini.demo.repository.NotificacionRepository;

@Service
public class NotificacionService {
	
	@Autowired
	private NotificacionRepository notificacionRepository;
	
	public Notificacion create (Notificacion noti) {
		return notificacionRepository.save(noti);
	}
	
	public List<Notificacion> getAllNotificaciones(){
		return notificacionRepository.findAll();
	}
	
	public void delete (Notificacion notificacion) {
		notificacionRepository.delete(notificacion);
	}
	
	public Optional<Notificacion> findById (Long id){
		return notificacionRepository.findById(id);
	}
	
	public void update (Notificacion notificacion) {
		Notificacion newNotificacion = notificacionRepository.getById(notificacion.getNotifyid());
		newNotificacion.setCuantity(notificacion.getCuantity());
		newNotificacion.setInfo(notificacion.getInfo());
		newNotificacion.setLamina(notificacion.getLamina());
		newNotificacion.setSolicitud(notificacion.isSolicitud());
		newNotificacion.setTitle(notificacion.getTitle());
		newNotificacion.setTokens(notificacion.getTokens());
		
		notificacionRepository.save(notificacion);
	}
}
