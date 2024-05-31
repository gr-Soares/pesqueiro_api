package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.ClienteComanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteComandaRepository extends JpaRepository<ClienteComanda, UUID> {
    Optional<ClienteComanda> findByComandaId(int id);
}
