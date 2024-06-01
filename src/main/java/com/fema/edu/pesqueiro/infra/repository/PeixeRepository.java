package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.Peixe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PeixeRepository extends JpaRepository<Peixe, UUID> {

    Optional<Peixe> findByEspecie(String especie);
}
