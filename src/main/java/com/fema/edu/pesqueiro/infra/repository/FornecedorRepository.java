package com.fema.edu.pesqueiro.infra.repository;


import com.fema.edu.pesqueiro.infra.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

    Optional<Fornecedor> findByCnpj(String cnpj);

}
