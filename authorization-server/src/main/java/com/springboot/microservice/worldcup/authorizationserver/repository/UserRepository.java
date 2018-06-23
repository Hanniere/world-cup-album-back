package com.springboot.microservice.worldcup.authorizationserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.microservice.worldcup.authorizationserver.model.User;


public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT user FROM User user WHERE LOWER(user.username) = LOWER(:username)")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("SELECT user FROM User user WHERE LOWER(user.email) = LOWER(:email)")
    Optional<User> findByUserEmail(@Param("email") String email);

}
