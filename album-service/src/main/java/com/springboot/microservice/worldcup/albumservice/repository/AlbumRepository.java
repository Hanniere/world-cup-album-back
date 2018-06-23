package com.springboot.microservice.worldcup.albumservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.microservice.worldcup.albumservice.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

	@Query("SELECT a FROM Album a WHERE LOWER(a.userId) = :userId")
    Optional<Album> findByUserId(@Param("userId") Integer userId);

}
