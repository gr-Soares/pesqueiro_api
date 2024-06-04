package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.ItemCardapio;
import com.fema.edu.pesqueiro.infra.repository.ItemCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemCardapioService {

    @Autowired
    ItemCardapioRepository repository;

    public ItemCardapio findById(UUID id) {
        Optional<ItemCardapio> result = repository.findById(id);
        return result.orElse(null);
    }

    public ItemCardapio findByNome(String nome) {
        Optional<ItemCardapio> result = repository.findByNome(nome);
        return result.orElse(null);
    }

    public List<ItemCardapio> findAll() {
        return repository.findAll();
    }

    public void insert(ItemCardapio itemCardapio) {
        itemCardapio.setId(null);
        repository.save(itemCardapio);
    }

    public void update(ItemCardapio itemCardapio) {
        repository.save(itemCardapio);
    }

    public void delete(UUID id) {
        ItemCardapio itemCardapio = findById(id);
        if (itemCardapio != null) {
            repository.delete(itemCardapio);
        }
    }
}
