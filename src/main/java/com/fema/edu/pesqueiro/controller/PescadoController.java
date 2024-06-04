package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.Pescado;
import com.fema.edu.pesqueiro.service.PescadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pescado")
public class PescadoController {

    @Autowired
    PescadoService service;

    @GetMapping
    public List<Pescado> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pescado findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Pescado pescado) {
        try {
            service.insert(pescado);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Pescado pescado) {
        try {
            service.update(pescado);
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
