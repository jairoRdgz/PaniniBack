package com.panini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panini.demo.model.Precio;

public interface PrecioRepository extends JpaRepository<Precio, Long>{

}
