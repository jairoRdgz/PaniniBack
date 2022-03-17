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

import com.panini.demo.model.Solicitud;
import com.panini.demo.services.BasicInfo;
import com.panini.demo.services.SolicitudService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping ("/api/users/solicitud/")
public class SolicitudREST {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@PostMapping
	private ResponseEntity<Solicitud> guardar (@RequestBody Solicitud solicitud ){
		
		Solicitud temporal = solicitudService.create(solicitud);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/solicitud"+temporal.getSolicitudid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	private ResponseEntity<List<Solicitud>> listarTodosLasSolicitudes (){
		return ResponseEntity.ok(solicitudService.getAllSolicitudes());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarSolicitud (@RequestBody Solicitud solicitud){
		solicitudService.delete(solicitud);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping()
	private ResponseEntity<Solicitud> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Solicitud solicitud){
		Optional<Solicitud> nuevo = solicitudService.findById(solicitud.getSolicitudid());
		solicitudService.update(solicitud);
		return ResponseEntity.ok(solicitud);
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Solicitud>> listarAlbumsPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(solicitudService.findById(id));
	}
}
