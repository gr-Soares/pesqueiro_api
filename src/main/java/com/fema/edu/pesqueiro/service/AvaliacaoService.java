package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Avaliacao;
import com.fema.edu.pesqueiro.infra.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoService {


    @Autowired
    AvaliacaoRepository repository;

    public Avaliacao findById(UUID id){
        Optional<Avaliacao> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<Avaliacao> findAll() { return repository.findAll(); }

    public void insert(Avaliacao avaliacao){
        avaliacao.setId(null);
        repository.save(avaliacao);
    }

    public void update(Avaliacao avaliacao) { repository.save(avaliacao); }

    public void delete(UUID id){
        Avaliacao avaliacao = findById(id);
        if(avaliacao != null){
            repository.delete(avaliacao);
        }
    }
}
