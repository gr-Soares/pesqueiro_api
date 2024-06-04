package com.fema.edu.pesqueiro.infra.repository;

import com.fema.edu.pesqueiro.infra.model.FornecedorPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorPagamentoRepository extends JpaRepository<FornecedorPagamento, UUID> {
}
