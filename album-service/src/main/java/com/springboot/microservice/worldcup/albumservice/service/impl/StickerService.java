package com.springboot.microservice.worldcup.albumservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.albumservice.exception.StickerNotFoundException;
import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;
import com.springboot.microservice.worldcup.albumservice.repository.StickerRepository;
import com.springboot.microservice.worldcup.albumservice.service.ServiceInterface;

/**
 * Service for retrieve, save, create and delete Stickers.
 * @author hveloso
 *
 */
@Service
public class StickerService implements ServiceInterface{

    @Autowired
    private StickerRepository stickerRepository;


    /**
     * Retrieve the sticker by id
     * @param id
     * @return album of the id
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Sticker findById(Long id) {
        LOGGER.info("Retrieving Sticker of id: " + id);
        return stickerRepository.findById(id).map(sticker -> new Sticker(sticker.getId(), sticker.getTeam(), sticker.getPicture(), sticker.getName()))
                .orElseThrow(() -> new StickerNotFoundException());
    }


    /**
     * This method retrieves all sticker from database
     * @return stickerList
     */
    @SuppressWarnings("unchecked")
    public Iterable<Sticker> findAll(){
        LOGGER.info("Retrieving all stickers from database");
        Iterable<Sticker> stickerList = stickerRepository.findAll();
        return stickerList;
    }

}
