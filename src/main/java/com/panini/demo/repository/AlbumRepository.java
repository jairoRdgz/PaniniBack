package com.panini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.panini.demo.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}