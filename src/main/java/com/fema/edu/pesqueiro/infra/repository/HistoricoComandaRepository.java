package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.HistoricoComanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HistoricoComandaRepository extends JpaRepository<HistoricoComanda, UUID> {
    List<HistoricoComanda> findByCpf(String cpf);
}


