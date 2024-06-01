package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Marca;
import com.fema.edu.pesqueiro.infra.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MarcaService {

    @Autowired
    MarcaRepository repository;

    public Marca findById(UUID id){
        Optional<Marca> result = repository.findById(id);
        return  result.orElse(null);
    }

    public Marca findByNome(String nome){
        Optional<Marca> result = repository.findByNome(nome);
        return result.orElse(null);
    }

    public List<Marca> findAll() { return repository.findAll(); }

    public void inset(Marca marca){
        marca.setId(null);
        repository.save(marca);
    }

    public void update(Marca marca) { repository.save(marca); }

    public void delete(UUID id){
        Marca marca = findById(id);
        if(marca != null){
            repository.delete(marca);
        }
    }
}
