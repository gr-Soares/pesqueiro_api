package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Pescado;
import com.fema.edu.pesqueiro.infra.repository.PescadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PescadoService {

    @Autowired
    PescadoRepository repository;

    public Pescado findById(UUID id) {
        Optional<Pescado> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<Pescado> findAll() { return repository.findAll(); }

    public void insert(Pescado pescado) {
        pescado.setId(null);
        repository.save(pescado);
    }

    public void update(Pescado pescado) { repository.save(pescado); }

    public void delete(UUID id) {
        Pescado pescado = findById(id);
        if(pescado != null){
            repository.delete(pescado);
        }
    }
}
