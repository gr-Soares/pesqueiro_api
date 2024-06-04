package com.fema.edu.pesqueiro.service;


import com.fema.edu.pesqueiro.infra.model.Fornecedor;
import com.fema.edu.pesqueiro.infra.model.Marca;
import com.fema.edu.pesqueiro.infra.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    public Fornecedor findById(UUID id) {
        Optional<Fornecedor> result = repository.findById(id);
        return result.orElse(null);
    }

    public Fornecedor findByCnpj(String cnpj) {
        Optional<Fornecedor> result = repository.findByCnpj(cnpj);
        return result.orElse(null);
    }

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public void insert(Fornecedor fornecedor) {
        fornecedor.setId(null);
        repository.save(fornecedor);
    }

    public void update(Fornecedor fornecedor) {
        repository.save(fornecedor);
    }

    public void delete(UUID id) {
        Fornecedor fornecedor = findById(id);
        if (fornecedor != null) {
            repository.delete(fornecedor);
        }
    }

    public Set<Marca> findMarcaById(UUID id) {
        Fornecedor fornecedor = findById(id);
        return fornecedor.getMarcas();
    }
}
