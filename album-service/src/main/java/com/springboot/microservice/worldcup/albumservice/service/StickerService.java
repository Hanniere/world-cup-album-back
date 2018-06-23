package com.springboot.microservice.worldcup.albumservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.albumservice.model.Sticker;
import com.springboot.microservice.worldcup.albumservice.repository.StickerRepository;

@Service
public class StickerService {

	@Autowired
	private StickerRepository stickerRepository;

	public Iterable<Sticker> findAll(){
		Iterable<Sticker> stickerList= stickerRepository.findAll();
		return stickerList;
	}

}
