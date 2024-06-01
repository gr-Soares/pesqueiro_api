package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.Pescado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PescadoRepository extends JpaRepository<Pescado, UUID> {}
