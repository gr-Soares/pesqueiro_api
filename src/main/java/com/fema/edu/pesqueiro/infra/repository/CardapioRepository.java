package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardapioRepository extends JpaRepository<Cardapio, UUID> {
}
