package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Lamina;
import com.panini.demo.repository.AlbumRepository;
import com.panini.demo.repository.LaminaRespository;

@Service
public class LaminaService {

	private LaminaRespository laminaRespository;
	
	private AlbumRepository albumRepository;
	
	@Autowired
	public LaminaService(LaminaRespository laminaRespository, AlbumRepository albumRepository) {
		this.laminaRespository = laminaRespository;
		this.albumRepository = albumRepository;
	}

	public Lamina create(Lamina lamina) {
		
		lamina.setAlbum(albumRepository.getById(lamina.getAlbum().getAlbumid()));
		return laminaRespository.save(lamina);
		
	}
	
	public List<Lamina> getAllLaminas(){
		return laminaRespository.findAll();
	}
	
	public void delete(Lamina lamina) {
		laminaRespository.delete(lamina);
	}
	
	public Optional<Lamina> findById(Long id){
		return laminaRespository.findById(id);
	}
	
	public void update (Lamina lamina) {
		Lamina newLamina = laminaRespository.getById(lamina.getLaminaid());
		newLamina.setCuantity(lamina.getCuantity());
		newLamina.setFilter(lamina.getFilter());
		
		laminaRespository.save(newLamina);
	}
}
