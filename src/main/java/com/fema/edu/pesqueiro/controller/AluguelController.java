package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.model.Aluguel;
import com.fema.edu.pesqueiro.infra.model.Fornecedor;
import com.fema.edu.pesqueiro.service.AluguelService;
import com.fema.edu.pesqueiro.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    AluguelService service;

    @GetMapping
    public List<Aluguel> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Aluguel findById(@PathVariable UUID id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Aluguel aluguel) {
        try{
            service.insert(aluguel);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Aluguel aluguel) {
        try{
            service.update(aluguel);
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
