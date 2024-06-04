package com.fema.edu.pesqueiro.controller;


import com.fema.edu.pesqueiro.infra.enums.TanqueStatus;
import com.fema.edu.pesqueiro.infra.model.Tanque;
import com.fema.edu.pesqueiro.service.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tanque")
public class TanqueController {

    @Autowired
    TanqueService service;

    @GetMapping
    public List<Tanque> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Tanque findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/status/{status}")
    public Tanque findByStatus(@PathVariable TanqueStatus status) {
        return service.findByStatus(status);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Tanque tanque) {
        try {
            service.insert(tanque);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Tanque tanque) {
        try {
            service.update(tanque);
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
