package com.fema.edu.pesqueiro.service;

import com.fema.edu.pesqueiro.infra.model.Cliente;
import com.fema.edu.pesqueiro.infra.model.ClienteComanda;
import com.fema.edu.pesqueiro.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente findById(UUID id) {
        Optional<Cliente> result = repository.findById(id);
        return result.orElse(null);
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> result = repository.findByCpf(cpf);
        return result.orElse(null);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public void insert(Cliente cliente) {
        cliente.setId(null);
        cliente.setClienteComanda(null);
        repository.save(cliente);
    }

    public void update(Cliente cliente) {
        repository.save(cliente);
    }

    public void delete(UUID id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            repository.delete(cliente);
        }
    }

    public ClienteComanda findComandaById(UUID id) {

        Cliente cliente = findById(id);

        if (cliente == null) {
            throw new RuntimeException("Cliente inexistente!");
        }

        ClienteComanda comanda = cliente.getClienteComanda();

        if (comanda == null) {
            throw new RuntimeException("Comanda inexistente!");
        }

        return comanda;
    }
}
