package com.panini.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panini.demo.model.Album;
import com.panini.demo.services.AlbumService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping ("/api/users/albums/")
public class AlbumREST {

	@Autowired
	private AlbumService albumService;
	
	@PostMapping//aqui debe ir el id del user
	private ResponseEntity<Album> guardar (@RequestBody Album album){
		// aqui debo llamar al user para asignarlo a un album
		Album temporal = albumService.create(album);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/albums"+temporal.getAlbumid())).body(temporal);
			
		}catch (Exception e) {
			System.out.println("mili es gay");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	private ResponseEntity<List<Album>> listarTodasLasPersona (){
		return ResponseEntity.ok(albumService.getAllAlbums());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody Album persona){
		albumService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Album>> listarPersonasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(albumService.findById(id));
	}
}
