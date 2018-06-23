package com.springboot.microservice.worldcup.albumservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.worldcup.albumservice.model.Sticker;
import com.springboot.microservice.worldcup.albumservice.service.StickerService;

@RestController
@RequestMapping(value = "/api/sticker", produces = MediaType.APPLICATION_JSON_VALUE)
public class StickerController {

	@Autowired
    private StickerService stickerService;



	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Sticker>> findAll(){
        return ResponseEntity.ok().body(stickerService.findAll());
    }

}
