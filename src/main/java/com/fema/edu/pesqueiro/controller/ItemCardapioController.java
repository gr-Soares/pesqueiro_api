package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.ItemCardapio;
import com.fema.edu.pesqueiro.service.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itemCardapio")
public class ItemCardapioController {

    @Autowired
    ItemCardapioService service;

    @GetMapping
    public List<ItemCardapio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemCardapio findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public ItemCardapio findByNome(@PathVariable String nome) {
        return service.findByNome(nome);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ItemCardapio itemCardapio) {
        try {
            service.insert(itemCardapio);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ItemCardapio itemCardapio) {
        try {
            service.update(itemCardapio);
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
