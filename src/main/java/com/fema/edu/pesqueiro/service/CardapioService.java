package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Cardapio;
import com.fema.edu.pesqueiro.infra.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardapioService {

    @Autowired
    CardapioRepository repository;

    public Cardapio findById(UUID id) {
        Optional<Cardapio> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<Cardapio> findAll() {
        return repository.findAll();
    }

    public void insert(Cardapio cardapio) {
        cardapio.setId(null);
        repository.save(cardapio);
    }

    public void update(Cardapio cardapio) {
        repository.save(cardapio);
    }

    public void delete(UUID id) {
        Cardapio cardapio = findById(id);
        if (cardapio != null) {
            repository.delete(cardapio);
        }
    }
}
