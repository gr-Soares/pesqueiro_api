package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, UUID> {
    Optional<ItemCardapio> findByNome(String nome);
}
