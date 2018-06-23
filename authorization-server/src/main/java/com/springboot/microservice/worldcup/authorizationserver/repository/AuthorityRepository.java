package com.springboot.microservice.worldcup.authorizationserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservice.worldcup.authorizationserver.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, String>{

    Authority findByName(String name);

}
