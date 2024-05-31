package com.fema.edu.pesqueiro.security;

import com.fema.edu.pesqueiro.infra.model.User;
import com.fema.edu.pesqueiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserService user;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return user.findByUsername(username);
    }

}