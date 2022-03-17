package com.panini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panini.demo.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long>{

}
