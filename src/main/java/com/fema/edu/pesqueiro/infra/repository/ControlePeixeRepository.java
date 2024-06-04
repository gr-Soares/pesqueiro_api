package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.ControlePeixe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ControlePeixeRepository extends JpaRepository<ControlePeixe, UUID> {
    List<ControlePeixe> findByTanqueId(UUID uuid);
}
