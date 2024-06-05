package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.dto.ConsumoDTO;
import com.fema.edu.pesqueiro.infra.model.ClienteComanda;
import com.fema.edu.pesqueiro.infra.model.Consumo;
import com.fema.edu.pesqueiro.infra.model.Produto;
import com.fema.edu.pesqueiro.infra.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumoService {

    @Autowired
    ConsumoRepository repository;

    @Autowired
    ComandaService comandaService;

    @Autowired
    ProdutoService produtoService;

    public Consumo findById(UUID id) {
        Optional<Consumo> result = repository.findById(id);
        return result.orElse(null);
    }

    public List<Consumo> findAll() {
        return repository.findAll();
    }

    public void insert(ConsumoDTO dto) {
        Consumo consumo = new Consumo();

        consumo.setComanda(dto.getComanda());
        consumo.setProduto(dto.getProduto());
        consumo.setValor(dto.getValor());
        consumo.setQtde(dto.getQtde());

        consumo.setDate(LocalDateTime.now());

        consumo.setId(null);

        Produto produto = dto.getProduto();
        Float qtde = produto.getQtde();

        produto.setQtde(qtde - dto.getQtde());

        produtoService.update(produto);

        ClienteComanda clienteComanda = comandaService.findbyComanda(consumo.getComanda().getId());

        comandaService.updateGasto(consumo.getValor(), clienteComanda);

        repository.save(consumo);
    }

    public void update(Consumo consumo) {
        repository.save(consumo);
    }

    public void delete(UUID id) {
        Consumo consumo = findById(id);
        if (consumo != null) {
            repository.delete(consumo);
        }
    }

    public List<Consumo> findByComanda(Integer id) {
        return repository.findByComandaId(id);
    }
}
