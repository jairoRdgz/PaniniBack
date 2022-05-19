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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panini.demo.model.Lamina;
import com.panini.demo.services.BasicInfo;
import com.panini.demo.services.LaminaService;

@RestController
@RequestMapping ("/api/users/{userid}/albums/lamina/")
public class LaminaREST {
	
	@Autowired
	private LaminaService laminaService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	private ResponseEntity<Lamina> guardar (@RequestBody Lamina persona, @RequestParam String userid){
		Lamina temporal = laminaService.create(persona);
		
		try {
			return ResponseEntity.created(new URI("/api/users/"+userid+"/albums/lamina"+temporal.getLaminaid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	private ResponseEntity<List<Lamina>> listarTodasLasPersona (){
		return ResponseEntity.ok(laminaService.getAllLaminas());
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody Lamina persona){
		laminaService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Lamina>> listarPersonasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(laminaService.findById(id));
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "{id}")
	private ResponseEntity<Lamina> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Lamina lamina){
		
		laminaService.update(lamina);
		return ResponseEntity.ok(lamina);
	}
	
}
