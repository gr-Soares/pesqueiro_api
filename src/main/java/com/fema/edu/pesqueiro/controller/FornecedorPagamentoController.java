package com.fema.edu.pesqueiro.controller;


import com.fema.edu.pesqueiro.infra.model.FornecedorPagamento;
import com.fema.edu.pesqueiro.service.FornecedorPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedorPagamento")
public class FornecedorPagamentoController {

    @Autowired
    FornecedorPagamentoService service;

    @GetMapping
    public List<FornecedorPagamento> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FornecedorPagamento findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody FornecedorPagamento fornecedorPagamento) {
        try {
            service.insert(fornecedorPagamento);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody FornecedorPagamento fornecedorPagamento) {
        try {
            service.update(fornecedorPagamento);
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
