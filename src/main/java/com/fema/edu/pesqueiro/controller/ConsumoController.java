package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.dto.ConsumoDTO;
import com.fema.edu.pesqueiro.infra.model.Consumo;
import com.fema.edu.pesqueiro.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consumo")
public class ConsumoController {

    @Autowired
    ConsumoService service;

    @GetMapping
    public List<Consumo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Consumo findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ConsumoDTO consumo) {
        try {
            service.insert(consumo);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Consumo consumo) {
        try {
            service.update(consumo);
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
