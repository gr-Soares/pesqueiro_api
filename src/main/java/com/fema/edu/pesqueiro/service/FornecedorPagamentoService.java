package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.FornecedorPagamento;
import com.fema.edu.pesqueiro.infra.repository.FornecedorPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FornecedorPagamentoService {

    @Autowired
    FornecedorPagamentoRepository repository;

    public FornecedorPagamento findById(UUID id) {
        Optional<FornecedorPagamento> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<FornecedorPagamento> findAll() { return repository.findAll(); }

    public void insert(FornecedorPagamento fornecedorPagamento){
        fornecedorPagamento.setId(null);
        repository.save(fornecedorPagamento);
    }

    public void update(FornecedorPagamento fornecedorPagamento) { repository.save(fornecedorPagamento); }

    public void delete(UUID id){
        FornecedorPagamento fornecedorPagamento = findById(id);
        if(fornecedorPagamento != null){
            repository.delete(fornecedorPagamento);
        }
    }

}
