package com.springboot.microservice.worldcup.albumservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.microservice.worldcup.albumservice.model.Album;
import com.springboot.microservice.worldcup.albumservice.model.Sticker;

public interface StickerRepository extends JpaRepository<Sticker, Integer>{

	@Query("SELECT s FROM Sticker s WHERE LOWER(s.name) = :name")
    Optional<Album> findByPlayerName(@Param("name") String name);

}
