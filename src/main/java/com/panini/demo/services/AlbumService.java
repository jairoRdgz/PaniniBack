package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.Album;
import com.panini.demo.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	
	public Album create (Album album) {
		return albumRepository.save(album);
	}
	
	public List<Album> getAllAlbums (){
		return albumRepository.findAll();
	}
	
	public void delete (Album album) {
		albumRepository.delete(album);
	}
	
	public Optional<Album> findById (Long id) {
		return albumRepository.findById(id);
	}
}