package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Peixe;
import com.fema.edu.pesqueiro.infra.repository.PeixeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeixeService {

    @Autowired
    PeixeRepository repository;

    public Peixe findById(UUID id) {
        Optional<Peixe> result = repository.findById(id);
        return  result.orElse(null);
    }

    public Peixe findByEspecie(String especie) {
        Optional<Peixe> result = repository.findByEspecie(especie);
        return  result.orElse(null);
    }

    public List<Peixe> findAll() { return repository.findAll(); }

    public void insert(Peixe peixe){
        peixe.setId(null);
        repository.save(peixe);
    }

    public void update(Peixe peixe) { repository.save(peixe); }

    public void delete(UUID id){
        Peixe peixe = findById(id);
        if(peixe != null){
            repository.delete(peixe);
        }
    }
}
