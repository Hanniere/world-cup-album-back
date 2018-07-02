package com.springboot.microservice.worldcup.albumservice.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springboot.microservice.worldcup.albumservice.exception.AlbumNotFoundException;
import com.springboot.microservice.worldcup.albumservice.model.impl.Album;
import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;
import com.springboot.microservice.worldcup.albumservice.repository.AlbumRepository;
import com.springboot.microservice.worldcup.albumservice.service.impl.AlbumService;


public class AlbumServiceTest {

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private Album album;

    @InjectMocks
    private AlbumService albumService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected=AlbumNotFoundException.class)
    public void findByIdThrowExceptionWhenThereIsNoAlbumWithId() {
        Optional<Album> mockReturn = Optional.ofNullable(null);
        when(albumRepository.findById(1L)).thenReturn(mockReturn);
        albumService.findById(1L);
        Assert.fail();
    }

    @Test
    public void returnAlbum() {
        when(albumRepository.findById(1L)).thenReturn(Optional.of(createMockAlbum(1L)));
        Album album = albumService.findById(1L);
        Assert.assertNotNull(album);
    }

    private Album createMockAlbum(Long id) {
        Album restaurant = new Album(id, 1L, 10.0, null);
        return restaurant;
    }

    private Sticker createMockSticker(Long id) {
        Sticker sticker = new Sticker(id, "Brazil", "url-picture" , "Neymar");
        return sticker;
    }

}
