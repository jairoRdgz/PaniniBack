package com.panini.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.panini.demo.model.Album;
import com.panini.demo.model.Lamina;

@SpringBootTest
class PruebaApiRestApplicationTests {
	
	Album album;
	
	@BeforeEach
	void setup() {
		album = new Album(12345678, "pepe");
		album.setUserref("1234");
	}

	@Test
	void laminaCreationTest() {
		Lamina lamina = new Lamina();
		 assertNotNull(lamina);
	}
	
	@Test
	void albumCreationTest() {
		Album album1 = new Album();
		assertNotNull(album1);
	}
	
	@Test
	void albumCreationTest2() {
		Album album1 = new Album();
		Album album2 = new Album();
		
		assertNotEquals(album1, album2);
	}

	@Test 
	void albumCreationTest3() {
		Album album1 = new Album(12345678, "Pepe");
		assertTrue(12345678==album1.getAlbumid());
	}
	
	@Test
	void albumGetters() {
		Long id = (long) 12345678;
		String name = "pepe";
		String user = "1234";
		assertEquals(id, album.getAlbumid());
		assertEquals(name, album.getAlbumName());
		assertEquals(user, album.getUserref());
	}
	
	@Test
	void albumSetIdTest() {
		Long id = album.getAlbumid();
		album.setAlbumid(111111111);
		Long id2 = album.getAlbumid();
		
		assertNotEquals(id, id2);
		
	}
	
	@Test
	void albumSetNameTest() {
		String name = album.getAlbumName();
		album.setAlbumName("prueba");
		String name2 = album.getAlbumName();
		
		assertNotEquals(name, name2);
		
	}
	
	@Test
	void albumSetUserrrefTest() {
		String user = album.getUserref();
		album.setUserref("nuevoRef");
		String user2 = album.getUserref();
		
		assertNotEquals(user, user2);
		
	}
	
	@Test
	void albumSetIdTest2() {
		album.setAlbumid(111111111);
		Long id2 = album.getAlbumid();
		assertEquals(111111111, id2);
	} 
	
	@Test
	void albumSetNameTest2() {
		album.setAlbumName("prueba");
		String name2 = album.getAlbumName();
		assertEquals("prueba", name2);
	}
	
	@Test
	void albumSetUserrrefTest2() {
		album.setUserref("nuevoRef");
		String user2 = album.getUserref();
		assertEquals("nuevoRef", user2);
	}
}
