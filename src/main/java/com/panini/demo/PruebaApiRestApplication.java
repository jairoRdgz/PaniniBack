package com.panini.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.panini.demo.model.Album;
import com.panini.demo.model.Lamina;
import com.panini.demo.repository.AlbumRepository;
import com.panini.demo.repository.LaminaRespository;

@SpringBootApplication
public class PruebaApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApiRestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner add(AlbumRepository albumRepository, LaminaRespository laminaRespository) {
		return (args) -> {
			
			Album a = new Album();
			a.setAlbumName("Vojabes");
			albumRepository.save(a);
			
			Lamina l1 = new Lamina();
			l1.setImg("https://www.laststicker.com/i/cards/3852/sp01.jpg");
			l1.setCuantity(2);
			l1.setAlbum(a);
			l1.setFilter(true);
			
			Lamina l2 = new Lamina();
			l2.setImg("https://www.laststicker.com/i/cards/3852/mr2.jpg");
			l2.setCuantity(2);
			l2.setAlbum(a);
			l2.setFilter(false);
			
			
			laminaRespository.save(l1);
			laminaRespository.save(l2);
		
			
		};
	}

}
