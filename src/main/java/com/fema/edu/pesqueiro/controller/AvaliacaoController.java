package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.Avaliacao;
import com.fema.edu.pesqueiro.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    AvaliacaoService service;

    @GetMapping
    public List<Avaliacao> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Avaliacao findById(@PathVariable UUID id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Avaliacao avaliacao) {
        try{
            service.insert(avaliacao);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Avaliacao avaliacao) {
        try{
            service.update(avaliacao);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try{
            service.delete(id);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
