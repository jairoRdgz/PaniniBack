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

import com.panini.demo.model.Precio;
import com.panini.demo.services.BasicInfo;
import com.panini.demo.services.PrecioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/api/precios/")
public class PrecioREST {

	@Autowired
	private PrecioService precioService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	private ResponseEntity<Precio> guardar (@RequestBody Precio album ){
		
		Precio temporal = precioService.create(album);
		
		try {	
			return ResponseEntity.created(new URI("/api/precios"+temporal.getPracioid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	
	@CrossOrigin(origins = "*")
	@GetMapping
	private ResponseEntity<List<Precio>> listarTodosLosAlbumes (){
		return ResponseEntity.ok(precioService.getAllPRecios());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarAlbum (@RequestBody Precio persona){
		precioService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "{id}")
	private ResponseEntity<Precio> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Precio album){
		
		precioService.update(album);
		return ResponseEntity.ok(album);
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Precio>> listarAlbumsPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(precioService.findById(id));
	}
}
