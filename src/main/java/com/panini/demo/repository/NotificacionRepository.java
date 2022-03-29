package com.panini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panini.demo.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}
