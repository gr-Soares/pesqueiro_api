package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.Cliente;
import com.fema.edu.pesqueiro.infra.model.ClienteComanda;
import com.fema.edu.pesqueiro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/cpf/{id}")
    public Cliente findByCpf(@PathVariable String id) {
        return service.findByCpf(id);
    }

    @GetMapping("/comanda/{id}")
    public ClienteComanda findComandaById(@PathVariable String id) {
        return service.findComandaById(UUID.fromString(id));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Cliente cliente) {
        try {
            service.insert(cliente);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cliente cliente) {
        try {
            service.update(cliente);
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
