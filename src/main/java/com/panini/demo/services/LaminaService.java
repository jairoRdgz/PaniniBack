package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Lamina;
import com.panini.demo.repository.LaminaRespository;

@Service
public class LaminaService {
	
	@Autowired
	private LaminaRespository laminaRespository;
	
	public Lamina create(Lamina lamina) {
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
}
