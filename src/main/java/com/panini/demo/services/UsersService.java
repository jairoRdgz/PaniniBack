package com.panini.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panini.demo.model.User;
import com.panini.demo.repository.UsersResporitory;

@Service
public class UsersService {
	
	@Autowired
	private UsersResporitory personaResporitory;
	
	public User create (User persona) {
		return personaResporitory.save(persona);
	}
	
	public List<User> getAllPersonas (){
		return personaResporitory.findAll();
	}
	
	public void delete (User persona) {
		personaResporitory.delete(persona);
	}
	
	public Optional<User> findById (String id) {
		return personaResporitory.findById(id);
	}
	
	public void update (User user) {
		User newUser = personaResporitory.getById(user.getUserid());
		newUser.setAlbums(user.getAlbums());
	}
}