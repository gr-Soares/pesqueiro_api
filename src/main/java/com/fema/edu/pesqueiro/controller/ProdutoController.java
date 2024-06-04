package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.enums.ProdutoTipo;
import com.fema.edu.pesqueiro.infra.model.Produto;
import com.fema.edu.pesqueiro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public List<Produto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Produto> findByTipo(@PathVariable("tipo") String produtoTipo) {
        return service.findByTipo(ProdutoTipo.valueOf(produtoTipo));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Produto produto) {
        try {
            service.insert(produto);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Produto produto) {
        try {
            service.update(produto);
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
