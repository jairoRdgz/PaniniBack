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

import com.panini.demo.model.User;
import com.panini.demo.services.UsersService;

@RestController
@RequestMapping ("/api/users/")
public class UsersREST {
	
	@Autowired
	private UsersService personaService;
	
	@PostMapping
	private ResponseEntity<User> guardar (@RequestBody User persona){
		User temporal = personaService.create(persona);
		
		try {
			return ResponseEntity.created(new URI("/api/users"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<User>> listarTodasLasPersona (){
		return ResponseEntity.ok(personaService.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody User persona){
		personaService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<User>> listarPersonasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(personaService.findById(id));
	}
	

}
