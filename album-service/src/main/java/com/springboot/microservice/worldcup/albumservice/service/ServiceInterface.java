package com.springboot.microservice.worldcup.albumservice.service;

import com.springboot.microservice.worldcup.albumservice.model.AbstractModel;

public interface ServiceInterface {

	AbstractModel findById(Integer id) throws Exception;

}
