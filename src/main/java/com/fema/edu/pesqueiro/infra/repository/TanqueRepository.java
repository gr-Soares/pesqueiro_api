package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.enums.TanqueStatus;
import com.fema.edu.pesqueiro.infra.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TanqueRepository extends JpaRepository<Tanque, UUID> {
    Optional<Tanque> findByStatus(TanqueStatus status);
}
