package com.springboot.microservice.worldcup.albumservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservice.worldcup.albumservice.model.impl.Album;
import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;
import com.springboot.microservice.worldcup.albumservice.service.impl.AlbumService;

@RestController
@RequestMapping(value = "/api/album", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/listAlbum")
    public ResponseEntity<Iterable<Album>> findAll(){
        return ResponseEntity.ok().body(albumService.findAll());
    }


    @PostMapping("/newAlbum")
    public ResponseEntity<Album> createNewAlbum(@RequestParam Long userId, @RequestParam Double price) {
        return ResponseEntity.ok().body(albumService.createNewAlbum(userId, price));
    }

    @PostMapping("/addSticker")
    public ResponseEntity<Album> addSticker(@RequestParam Long albumId, @RequestBody Sticker sticker) {
        return ResponseEntity.ok().body(albumService.addSticker(albumId, sticker));
    }
}
