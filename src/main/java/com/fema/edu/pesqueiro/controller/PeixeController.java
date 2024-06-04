package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.Peixe;
import com.fema.edu.pesqueiro.service.PeixeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/peixe")
public class PeixeController {

    @Autowired
    PeixeService service;

    @GetMapping
    public List<Peixe> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Peixe findByID(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/especie/{especie}")
    public Peixe findByEspecie(@PathVariable String especie) {
        return service.findByEspecie(especie);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Peixe peixe) {
        try {
            service.insert(peixe);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Peixe peixe) {
        try {
            service.update(peixe);
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
