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
import com.panini.demo.model.User;
import com.panini.demo.services.AlbumService;
import com.panini.demo.services.BasicInfo;
import com.panini.demo.services.LaminaService;
import com.panini.demo.services.UsersService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/api/users/")
public class UsersREST {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired 
	private LaminaService laminaService;
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Users
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping
	private ResponseEntity<User> guardarPersona (@RequestBody User persona){
		User temporal = userService.create(persona);
		
		try {
			return ResponseEntity.created(new URI("/api/users"+temporal.getFirebaseid())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<User>> listarTodasLasPersona (){
		return ResponseEntity.ok(userService.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody User persona){
		userService.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{userid}")
	private ResponseEntity<Optional<User>> listarPersonasPorID (@PathVariable ("userid") String userid){
		return ResponseEntity.ok(userService.findById(userid));
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Albums
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("{userid}/albums")
	private ResponseEntity<Album> guardarAlbum (@RequestBody Album album, @PathVariable(value="userid") String userid){
		

		for(int i = 0; i< album.getLaminas().size(); i++) {
			laminaService.create(album.getLaminas().get(i));
		}
		
		Album temporal = albumService.create(album, userid);
		Album temporal2 = albumService.create2(album);
		
		try {	
			ResponseEntity.created(new URI("/api/users/albums"+temporal2.getAlbumid())).body(temporal2);
			return ResponseEntity.created(new URI("/api/users/"+userid+"/albums"+temporal.getAlbumid())).body(temporal);
			
		}catch (Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/albums/")
	private ResponseEntity<Album> guardarAlbum2 (@RequestBody Album album){
		

		for(int i = 0; i< album.getLaminas().size(); i++) {
			laminaService.create(album.getLaminas().get(i));
		}
		
		Album temporal2 = albumService.create2(album);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/albums"+temporal2.getAlbumid())).body(temporal2);
			
		}catch (Exception e) {
			
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/albums/")
	private ResponseEntity<List<Album>> listarTodosLosAlbumes (){
		System.out.println("entre");
		return ResponseEntity.ok(albumService.getAllAlbums());
	}
	
	@GetMapping("{userid}/albums")
	private ResponseEntity<List<Album>> listarTodosLosAlbumesdeUnusuario (@PathVariable(value="userid") String userid){
		System.out.println("entre");
		return ResponseEntity.ok(userService.findById(userid).get().getAlbums());
	}
	
	@DeleteMapping("{userid}/albums/")
	private ResponseEntity<Void> eliminarAlbum (@RequestBody Album album, @PathVariable(value="userid") String userid){
		album = userService.findById(userid).get().getAlbums().get(0);
		albumService.delete(album);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "{userid}/albums/{id}")
	private ResponseEntity<Album> actualizarAlbum(@PathVariable(value="id") long id, @Validated(BasicInfo.class) @RequestBody Album album, @PathVariable(value="userid") String userid){
		album = userService.findById(userid).get().getAlbums().get(0);
		albumService.update(album);
		return ResponseEntity.ok(album);
	}
	
	@GetMapping (value = "{userid}/albums/{id}")
	private ResponseEntity<Optional<Album>> listarAlbumsPorID (@PathVariable ("id") long id){
		return ResponseEntity.ok(albumService.findById(id));
	}
}
