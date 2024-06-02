package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Aluguel;
import com.fema.edu.pesqueiro.infra.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AluguelService {

    @Autowired
    AluguelRepository repository;

    public Aluguel findById(UUID id){
        Optional<Aluguel> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<Aluguel> findAll() { return repository.findAll(); }

    public void insert(Aluguel aluguel){
        aluguel.setId(null);
        repository.save(aluguel);
    }

    public void update(Aluguel aluguel) { repository.save(aluguel); }

    public void delete(UUID id){
        Aluguel aluguel = findById(id);
        if(aluguel != null){
            repository.delete(aluguel);
        }
    }
}
