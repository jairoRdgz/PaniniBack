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

import com.panini.demo.model.Album;
import com.panini.demo.services.AlbumService;
import com.panini.demo.services.BasicInfo;
import com.panini.demo.services.LaminaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping ("/api/users/albums/")
public class AlbumREST {

	@Autowired
	private AlbumService albumService;
	
	
	@PostMapping
	private ResponseEntity<Album> guardar (@RequestBody Album album ){
		
		Album temporal = albumService.create(album);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/albums"+temporal.getAlbumid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	private ResponseEntity<List<Album>> listarTodosLosAlbumes (){
		return ResponseEntity.ok(albumService.getAllAlbums());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarAlbum (@RequestBody Album persona){
		albumService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping()
	private ResponseEntity<Album> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Album album){
		Optional<Album> nuevo = albumService.findById(album.getAlbumid());
		albumService.update(album);
		return ResponseEntity.ok(album);
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Album>> listarAlbumsPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(albumService.findById(id));
	}
	
	
}
