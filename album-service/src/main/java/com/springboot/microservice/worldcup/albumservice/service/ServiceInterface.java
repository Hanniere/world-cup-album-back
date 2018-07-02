package com.springboot.microservice.worldcup.albumservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service interface that determines the resources common behavior of the Album microservice.
 * @author Hanniere
 *
 */
public interface ServiceInterface {
    final Logger LOGGER = LoggerFactory.getLogger(ServiceInterface.class);

    public <T> T findById (Long id) ;

    public <T> Iterable<T> findAll() ;

}
