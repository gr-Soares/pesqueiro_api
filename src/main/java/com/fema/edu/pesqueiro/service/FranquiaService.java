package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Franquia;
import com.fema.edu.pesqueiro.infra.repository.FranquiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FranquiaService {

    @Autowired
    FranquiaRepository repository;

    public Franquia findById(UUID id) {
        Optional<Franquia> result = repository.findById(id);
        return result.orElse(null);
    }

    public Franquia findByNome(String nome) {
        Optional<Franquia> result = repository.findByNome(nome);
        return result.orElse(null);
    }

    public List<Franquia> findAll() {
        return repository.findAll();
    }

    public void insert(Franquia franquia) {
        franquia.setId(null);
        repository.save(franquia);
    }

    public void update(Franquia franquia) {
        repository.save(franquia);
    }

    public void delete(UUID id) {
        Franquia franquia = findById(id);
        if (franquia != null) {
            repository.delete(franquia);
        }
    }
}
