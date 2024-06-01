package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.enums.ProdutoTipo;
import com.fema.edu.pesqueiro.infra.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    Optional<Produto> findByTipo(ProdutoTipo tipo);
}
