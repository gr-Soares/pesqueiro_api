package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.dto.PasswordUpdateDTO;
import com.fema.edu.pesqueiro.dto.UserUpdateDTO;
import com.fema.edu.pesqueiro.infra.model.User;
import com.fema.edu.pesqueiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{uuid}")
    public User findById(@PathVariable("uuid") UUID uuid) {
        return service.findById(uuid);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody User user) {
        try {
            service.insert(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserUpdateDTO user) {
        try {
            User result = service.update(user);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/password_update")
    public ResponseEntity<User> update(@RequestBody PasswordUpdateDTO upt) {
        try {
            User result = service.updatePassword(upt);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
