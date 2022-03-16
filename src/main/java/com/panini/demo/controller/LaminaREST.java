package com.panini.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panini.demo.model.Lamina;
import com.panini.demo.services.LaminaService;

@RestController
@RequestMapping ("/api/users/albums/lamina/")
public class LaminaREST {
	
	@Autowired
	private LaminaService laminaService;
	
	@PostMapping
	private ResponseEntity<Lamina> guardar (@RequestBody Lamina persona){
		Lamina temporal = laminaService.create(persona);
		
		try {
			return ResponseEntity.created(new URI("/api/users/albums/lamina"+temporal.getLaminaid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Lamina>> listarTodasLasPersona (){
		return ResponseEntity.ok(laminaService.getAllLaminas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody Lamina persona){
		laminaService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Lamina>> listarPersonasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(laminaService.findById(id));
	}
	
}
