package com.panini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.panini.demo.model.User;

public interface UsersResporitory extends JpaRepository<User, String>{

}