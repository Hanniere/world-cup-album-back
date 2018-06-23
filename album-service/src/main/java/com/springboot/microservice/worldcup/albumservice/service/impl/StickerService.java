package com.springboot.microservice.worldcup.albumservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;
import com.springboot.microservice.worldcup.albumservice.repository.StickerRepository;

/**
 * Service for retrieve, save, create and delete Stickers.
 * @author hveloso
 *
 */
@Service
public class StickerService {

	@Autowired
	private StickerRepository stickerRepository;

//	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


	/**
	 * Retrieve the sticker by id
	 * @param id
	 * @return album of the id
	 * @throws Exception
	 */
	public Sticker findById(Integer id) throws Exception{
		return stickerRepository.findById(id).map(sticker -> new Sticker(sticker.getId(), sticker.getTeam(), sticker.getPicture(), sticker.getName()))
				.orElseThrow(() -> new Exception("Sticker Not found"));
	}


	/**
	 * This method retrieves all sticker from database
	 * @return stickerList
	 */
	public Iterable<Sticker> findAll(){
//		LOGGER.info("Retrieving all stickers from database");
		Iterable<Sticker> stickerList = stickerRepository.findAll();
		return stickerList;
	}

}
