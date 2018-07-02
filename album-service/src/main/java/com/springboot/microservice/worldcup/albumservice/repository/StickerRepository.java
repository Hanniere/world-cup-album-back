package com.springboot.microservice.worldcup.albumservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.microservice.worldcup.albumservice.model.impl.Album;
import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;

/**
 * Repository for Sticker
 * @author hveloso
 *
 */
public interface StickerRepository extends JpaRepository<Sticker, Long>{

    @Query("SELECT s FROM Sticker s WHERE LOWER(s.name) = :name")
    Optional<Album> findByPlayerName(@Param("name") String name);

}
