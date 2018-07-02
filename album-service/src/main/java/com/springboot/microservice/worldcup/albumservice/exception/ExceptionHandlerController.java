package com.springboot.microservice.worldcup.albumservice.exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller responsible of intercept and handle exeption trown by the application
 * @author Hanniere
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validateError(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body(ex.getConstraintViolations().stream().map(cv -> cv.getMessage()).collect(Collectors.toList()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> otherErrors(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(AlbumNotFoundException.class)
    public ResponseEntity<?> otherErrors(AlbumNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Album not found");
    }

    @ExceptionHandler(StickerNotFoundException.class)
    public ResponseEntity<?> otherErrors(StickerNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sticker not found");
    }

}