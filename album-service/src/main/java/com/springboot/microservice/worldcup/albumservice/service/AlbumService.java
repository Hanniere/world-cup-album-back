package com.springboot.microservice.worldcup.albumservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.albumservice.model.Album;
import com.springboot.microservice.worldcup.albumservice.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;


	public Album findById(Integer id) throws Exception{
		return albumRepository.findById(id).map(album -> new Album(album.getId(), album.getUserId(), album.getPrice(), album.getStickerList()))
				.orElseThrow(() -> new Exception("Album Not found"));
	}

	public Iterable<Album> findAll(){
		return albumRepository.findAll();
	}

}
