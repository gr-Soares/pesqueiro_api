package com.fema.edu.pesqueiro.controller;

import com.fema.edu.pesqueiro.infra.enums.ComandaStatus;
import com.fema.edu.pesqueiro.infra.enums.HistComandaStatus;
import com.fema.edu.pesqueiro.infra.model.ClienteComanda;
import com.fema.edu.pesqueiro.infra.model.Comanda;
import com.fema.edu.pesqueiro.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comanda")
public class ComandaController {

    @Autowired
    ComandaService service;

    @GetMapping("/status/{status}")
    public List<Comanda> findByStatus(@PathVariable("status") ComandaStatus status){
        return service.findByStatus(status);
    }

    @GetMapping("/id/{id}")
    public ClienteComanda findById(@PathVariable("id") int id){
        return service.findbyComanda(id);
    }

    @PostMapping("/open/{id}")
    public ResponseEntity<?> open(@PathVariable("id") UUID cliente_id){
        try{
            LocalDateTime entrada = LocalDateTime.now();
            service.open(entrada, cliente_id);

            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/close/{id}/{status}")
    public ResponseEntity<?> close(@PathVariable("id") UUID cliente_id, @PathVariable("status") HistComandaStatus status){
        try{
            LocalDateTime saida = LocalDateTime.now();
            service.close(saida, status, "", cliente_id, true);

            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/{value}")
    public ClienteComanda updateValue(@PathVariable("id") UUID id, @PathVariable("value") float valor){
        return service.updateGasto(valor, id);
    }
}
