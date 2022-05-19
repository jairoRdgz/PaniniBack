package com.panini.demo.controller;


/*
@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/api/users/{userid}/albums/")
public class AlbumREST {

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private UsersService usersService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	private ResponseEntity<Album> guardar (@RequestBody Album album, @RequestParam String userid ){
		
		Album temporal = albumService.create(album, userid);
		
		try {	
			return ResponseEntity.created(new URI("/api/users/"+userid+"/albums"+temporal.getAlbumid())).body(temporal);
			
		}catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	@CrossOrigin(origins = "*")
	@GetMapping
	private ResponseEntity<List<Album>> listarTodosLosAlbumes (@RequestParam String userid){
		return ResponseEntity.ok(usersService.findById(userid).get().getAlbums());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarAlbum (@RequestBody Album album){
		albumService.delete(album);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "{id}")
	private ResponseEntity<Album> actualizarAlbum(@PathVariable(value="id") Long id, @Validated(BasicInfo.class) @RequestBody Album album){
		
		albumService.update(album);
		return ResponseEntity.ok(album);
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Album>> listarAlbumsPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(albumService.findById(id));
	}
	
	
}
*/
