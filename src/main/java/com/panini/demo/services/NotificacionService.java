package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Notificacion;
import com.panini.demo.repository.NotificacionRepository;
import com.panini.demo.repository.UsersResporitory;

@Service
public class NotificacionService {
	
	@Autowired
	private NotificacionRepository notificacionRepository;
	
	@Autowired
	private UsersResporitory usersResporitory; 
	
	public Notificacion create (Notificacion noti, String userid) {
		noti.setUser(usersResporitory.findById(userid).get());
		usersResporitory.findById(userid).get().addNotificacion(noti);
		notificacionRepository.save(noti);
		return noti;
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
		newNotificacion.setType(notificacion.getType());
		newNotificacion.setTitle(notificacion.getTitle());
		newNotificacion.setTokens(notificacion.getTokens());
		
		notificacionRepository.save(notificacion);
	}
}
