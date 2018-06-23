package com.springboot.microservice.worldcup.authorizationserver.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.microservice.worldcup.authorizationserver.model.Authority;
import com.springboot.microservice.worldcup.authorizationserver.model.User;
import com.springboot.microservice.worldcup.authorizationserver.repository.UserRepository;


@Service
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByUsername(name)
                                .map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user)))
                                .orElseThrow(() -> new UsernameNotFoundException("User "+name+" Not found"));
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user){
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }

        return grantedAuthorities;
    }
}
