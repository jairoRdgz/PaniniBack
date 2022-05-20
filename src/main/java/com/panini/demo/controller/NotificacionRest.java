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
import com.panini.demo.services.UsersService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/api/users/{userid}/notifys/")
public class NotificacionRest {

	@Autowired
	private NotificacionService notificacionService;
	
	@Autowired
	private UsersService usersService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	private ResponseEntity<Notificacion> guardar (@RequestBody Notificacion notificacion, @PathVariable(value="userid") String userid ){
		
		Notificacion temporal = notificacionService.create(notificacion);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/"+userid+"/notifys"+temporal.getNotifyid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	private ResponseEntity<List<Notificacion>> listarTodosLosAlbumes (@PathVariable(value="userid") String userid ){
		return ResponseEntity.ok(usersService.findById(userid).get().getNotificaciones());
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping
	private ResponseEntity<Void> eliminarNotificacion (@RequestBody Notificacion notificacion){
		notificacionService.delete(notificacion);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "{id}")
	private ResponseEntity<Notificacion> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Notificacion notificacion){
		
		notificacionService.update(notificacion);
		return ResponseEntity.ok(notificacion);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Notificacion>> listarAlbumsPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(notificacionService.findById(id));
	}
}
