package com.fema.edu.pesqueiro.controller;


import com.fema.edu.pesqueiro.infra.model.Fornecedor;
import com.fema.edu.pesqueiro.infra.model.Marca;
import com.fema.edu.pesqueiro.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @GetMapping
    public List<Fornecedor> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Fornecedor findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/marcas/{id}")
    public Set<Marca> findMarcaById(@PathVariable String id) {
        return service.findMarcaById(UUID.fromString(id));
    }

    @GetMapping("/cnpj/{cnpj}")
    public Fornecedor findByCnpj(@PathVariable String cnpj) {
        return service.findByCnpj(cnpj);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Fornecedor fornecedor) {
        try {
            service.insert(fornecedor);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Fornecedor fornecedor) {
        try {
            service.update(fornecedor);
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
