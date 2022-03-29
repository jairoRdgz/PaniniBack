package com.panini.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panini.demo.model.Notificacion;
import com.panini.demo.services.BasicInfo;
import com.panini.demo.services.NotificacionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping ("/api/users/notifys/")
public class NotificacionRest {

	@Autowired
	private NotificacionService notificacionService;
	
	@PostMapping
	private ResponseEntity<Notificacion> guardar (@RequestBody Notificacion notificacion ){
		
		Notificacion temporal = notificacionService.create(notificacion);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/notifys"+temporal.getNotifyid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	private ResponseEntity<List<Notificacion>> listarTodosLosAlbumes (){
		return ResponseEntity.ok(notificacionService.getAllNotificaciones());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarNotificacion (@RequestBody Notificacion notificacion){
		notificacionService.delete(notificacion);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value = "{id}")
	private ResponseEntity<Notificacion> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Notificacion notificacion){
		
		notificacionService.update(notificacion);
		return ResponseEntity.ok(notificacion);
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Notificacion>> listarAlbumsPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(notificacionService.findById(id));
	}
}
