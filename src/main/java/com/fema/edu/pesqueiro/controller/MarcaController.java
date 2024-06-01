package com.fema.edu.pesqueiro.controller;


import com.fema.edu.pesqueiro.infra.model.Marca;
import com.fema.edu.pesqueiro.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService service;

    @GetMapping
    public List<Marca> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Marca findById(@PathVariable UUID id) { return service.findById(id); }

    @GetMapping("/nome/{nome}")
    public Marca findByNome(@PathVariable String nome) { return service.findByNome(nome); }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Marca marca) {
        try {
            service.inset(marca);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Marca marca) {
        try {
            service.update(marca);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

}
