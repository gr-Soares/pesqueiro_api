package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.ControlePeixe;
import com.fema.edu.pesqueiro.infra.repository.ControlePeixeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ControlePeixeService {

    @Autowired
    ControlePeixeRepository repository;

    public ControlePeixe findById(UUID id) {
        Optional<ControlePeixe> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<ControlePeixe> findAll() {
        return repository.findAll();
    }

    public void insert(ControlePeixe controlePeixe) {
        controlePeixe.setId(null);
        repository.save(controlePeixe);
    }

    public void update(ControlePeixe controlePeixe) {
        repository.save(controlePeixe);
    }

    public void delete(UUID id) {
        ControlePeixe controlePeixe = findById(id);
        if (controlePeixe != null) {
            repository.delete(controlePeixe);
        }
    }

    public List<ControlePeixe> findByTanque(UUID uuid) {
        return repository.findByTanqueId(uuid);
    }
}
