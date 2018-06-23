package com.springboot.microservice.worldcup.albumservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.worldcup.albumservice.model.Album;
import com.springboot.microservice.worldcup.albumservice.service.AlbumService;

@RestController
@RequestMapping(value = "/api/album", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlbumController {

	@Autowired
    private AlbumService albumService;

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Album>> findAll(){
        return ResponseEntity.ok().body(albumService.findAll());
    }



}
