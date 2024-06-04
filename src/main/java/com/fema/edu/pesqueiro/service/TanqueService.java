package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.enums.TanqueStatus;
import com.fema.edu.pesqueiro.infra.model.Tanque;
import com.fema.edu.pesqueiro.infra.repository.TanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TanqueService {

    @Autowired
    TanqueRepository repository;

    public Tanque findById(UUID id) {
        Optional<Tanque> result = repository.findById(id);
        return result.orElse(null);
    }

    public Tanque findByStatus(TanqueStatus status) {
        Optional<Tanque> result = repository.findByStatus(status);
        return result.orElse(null);
    }

    public List<Tanque> findAll() {
        return repository.findAll();
    }

    public void insert(Tanque tanque) {
        tanque.setId(null);
        repository.save(tanque);
    }

    public void update(Tanque tanque) {
        repository.save(tanque);
    }

    public void delete(UUID id) {
        Tanque tanque = findById(id);
        if (tanque != null) {
            repository.delete(tanque);
        }
    }
}
