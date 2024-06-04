package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.Cardapio;
import com.fema.edu.pesqueiro.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    CardapioService service;

    @GetMapping
    public List<Cardapio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cardapio findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Cardapio cardapio) {
        try {
            service.insert(cardapio);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cardapio cardapio) {
        try {
            service.update(cardapio);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
