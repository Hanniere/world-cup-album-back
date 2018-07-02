package com.springboot.microservice.worldcup.albumservice.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springboot.microservice.worldcup.albumservice.exception.StickerNotFoundException;
import com.springboot.microservice.worldcup.albumservice.model.impl.Sticker;
import com.springboot.microservice.worldcup.albumservice.repository.StickerRepository;
import com.springboot.microservice.worldcup.albumservice.service.impl.StickerService;

public class StickerServiceTest {

    @Mock
    private StickerRepository stickerRepository;

    @InjectMocks
    private StickerService stickerService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected=StickerNotFoundException.class)
    public void findByIdThrowExceptionWhenThereIsNoStickerWithId() {
        Optional<Sticker> mockReturn = Optional.ofNullable(null);
        when(stickerRepository.findById(1L)).thenReturn(mockReturn);
        stickerService.findById(1L);
        Assert.fail();
    }

}
