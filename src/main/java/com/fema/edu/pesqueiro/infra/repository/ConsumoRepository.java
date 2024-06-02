package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsumoRepository extends JpaRepository<Consumo, UUID> {}
