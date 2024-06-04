package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.ControlePeixe;
import com.fema.edu.pesqueiro.service.ControlePeixeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/controle_peixe")
public class ControlePeixeController {

    @Autowired
    ControlePeixeService service;

    @GetMapping
    public List<ControlePeixe> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ControlePeixe findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/tanque/{id}")
    public List<ControlePeixe> findByTanque(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        return service.findByTanque(uuid);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ControlePeixe controlePeixe) {
        try {
            service.insert(controlePeixe);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ControlePeixe controlePeixe) {
        try {
            service.update(controlePeixe);
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
