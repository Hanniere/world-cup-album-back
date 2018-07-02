package com.springboot.microservice.worldcup.albumservice.service.impl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.albumservice.exception.AlbumNotFoundException;
import com.springboot.microservice.worldcup.albumservice.model.impl.Album;
import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;
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


    /**
     * Retrieve the album by id
     * @param id
     * @return album of the id
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Album findById(Long id) {
        LOGGER.info("Retrieving Album of id: " + id);
        return albumRepository.findById(id).map(album -> new Album(album.getId(), album.getUserId(), album.getPrice(), album.getStickerSet()))
                .orElseThrow(() -> new AlbumNotFoundException());
    }

    @SuppressWarnings("unchecked")
    public Iterable<Album> findAll(){
        LOGGER.info("Retrieving list of Album from database");
        return albumRepository.findAll();
    }

    /**
     * Create a new Album for a user.
     * @param userId
     * @param price
     * @return new Album
     */
    public Album createNewAlbum(Long userId, Double price) {
        Album album = new Album(userId, price);
        LOGGER.info("Creating new Album");
        return albumRepository.save(album);
    }

    /**
     * This method retrieves the number of Stickers of a Album
     * @param album
     * @return number of stickers
     */
    public Integer retriveNumberOfStickers(Album album) {
        LOGGER.info("Retrieving Sticker list size of Album: " + album.getId());
        return album.getStickerSet().size();
    }

    /**
     * Add a sticker in a existing album.
     * @param albumId
     * @param sticker
     * @return updated album
     * @throws Exception
     */
    public Album addSticker(Long albumId, Sticker sticker) {
        Album album = findById(albumId);
        Set<Sticker> stickerSet = album.getStickerSet();

        if(stickerSet==null)
            stickerSet = new HashSet<>();

        LOGGER.info("Adding Sticker of the player "+sticker.getName()+" in the album:  " + album.getId());
        stickerSet.add(sticker);

        return albumRepository.save(album);
    }

}
