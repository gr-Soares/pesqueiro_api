package com.fema.edu.pesqueiro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public ResponseEntity<String> base() {
        return ResponseEntity.status(HttpStatus.OK).body("Serviço Rodando!");
    }

}
