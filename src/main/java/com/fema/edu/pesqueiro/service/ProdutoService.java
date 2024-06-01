package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.enums.ProdutoTipo;
import com.fema.edu.pesqueiro.infra.model.Produto;
import com.fema.edu.pesqueiro.infra.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto findById(UUID id){
        Optional<Produto> result = repository.findById(id);
        return  result.orElse(null);
    }

    public Produto findByTipo(ProdutoTipo produtoTipo){
        Optional<Produto> result = repository.findByTipo(produtoTipo);
        return result.orElse(null);
    }

    public List<Produto> findAll() { return  repository.findAll(); }

    public void insert(Produto produto){
        produto.setId(null);
        repository.save(produto);
    }

    public void update(Produto produto) { repository.save(produto); }

    public void delete(UUID id){
        Produto produto = findById(id);
        if(produto != null){
            repository.delete(produto);
        }
    }
}
