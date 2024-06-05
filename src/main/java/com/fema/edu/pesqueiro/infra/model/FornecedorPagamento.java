package com.fema.edu.pesqueiro.infra.model;


import com.fema.edu.pesqueiro.infra.enums.FornecedorPagamentoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "fornecedor_pagamento")
@Table(name = "fornecedor_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FornecedorPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Float qtde;
    private FornecedorPagamentoStatus status;
    private LocalDateTime data_p;
    private LocalDateTime data_e;
    private String obs;
    private String nota;

    @ManyToOne
    private Produto produto;
}
