package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Consumo;
import com.fema.edu.pesqueiro.infra.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumoService {

    @Autowired
    ConsumoRepository repository;

    public Consumo findById(UUID id){
        Optional<Consumo> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<Consumo> findAll() { return repository.findAll(); }

    public void insert(Consumo consumo){
        consumo.setId(null);
        repository.save(consumo);
    }

    public void update(Consumo consumo) { repository.save(consumo); }

    public void delete(UUID id){
        Consumo consumo = findById(id);
        if(consumo != null){
            repository.delete(consumo);
        }
    }
}
