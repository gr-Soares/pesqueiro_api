package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.enums.ComandaStatus;
import com.fema.edu.pesqueiro.infra.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {
    List<Comanda> findByStatus(ComandaStatus status);
}
