package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Precio;
import com.panini.demo.repository.PrecioRepository;

@Service
public class PrecioService {
	@Autowired
	private PrecioRepository precioRepository;
	
	
	public Precio create (Precio precio) {
		precioRepository.save(precio);
		return precio;
	}
	
	public List<Precio> getAllPRecios(){
		return precioRepository.findAll();
	}
	
	public void delete (Precio precio) {
		precioRepository.delete(precio);
	}
	
	public Optional<Precio> findById(Long id){
		return precioRepository.findById(id);
	}
	
	public void update (Precio precio) {
		//Precio newPrecio = precioRepository.getById(precio.getPrecioid());
		//newPrecio.setCategory(precio.getCategory());
		//newPrecio.setLamina(precio.getLamina());
		//newPrecio.setNumber(precio.getNumber());
		//newPrecio.setPrice(precio.getPrice());
		//newPrecio.setSection(precio.getSection());
	}
}
