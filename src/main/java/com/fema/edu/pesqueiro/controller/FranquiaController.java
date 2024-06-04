package com.fema.edu.pesqueiro.controller;


import com.fema.edu.pesqueiro.infra.model.Franquia;
import com.fema.edu.pesqueiro.service.FranquiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/franquia")
public class FranquiaController {

    @Autowired
    FranquiaService service;

    @GetMapping
    public List<Franquia> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Franquia findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public Franquia findByNome(@PathVariable String nome) {
        return service.findByNome(nome);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Franquia franquia) {
        try {
            service.insert(franquia);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Franquia franquia) {
        try {
            service.update(franquia);
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
