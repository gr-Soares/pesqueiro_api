package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.Franquia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FranquiaRepository extends JpaRepository<Franquia, UUID> {
    Optional<Franquia> findByNome(String nome);
}
