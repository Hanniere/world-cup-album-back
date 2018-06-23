package com.springboot.microservice.worldcup.albumservice.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.albumservice.model.impl.Album;
import com.springboot.microservice.worldcup.albumservice.repository.AlbumRepository;
import com.springboot.microservice.worldcup.albumservice.service.ServiceInterface;


/**
 * Service for retrieve, save, create and delete Albums.
 * @author hveloso
 *
 */
@Service
public class AlbumService implements ServiceInterface{

	@Autowired
	private AlbumRepository albumRepository;

//	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * Retrieve the album by id
	 * @param id
	 * @return album of the id
	 * @throws Exception
	 */
	public Album findById(Integer id) throws Exception{
		return albumRepository.findById(id).map(album -> new Album(album.getId(), album.getUserId(), album.getPrice(), album.getStickerSet()))
				.orElseThrow(() -> new Exception("Album Not found"));
	}

	public Iterable<Album> findAll(){
//		LOGGER.info("Retrieving all stickers from database");
		return albumRepository.findAll();
	}

	/**
	 * This method retrieves the number of Stickers of a Album
	 * @param album
	 * @return number of stickers
	 */
	public Integer retriveNumberOfStickers(Album album) {
//		LOGGER.info("Retrieving Sticker size of Album: " + album.getId());
		return album.getStickerSet().size();
	}

}
