package com.fema.edu.pesqueiro.infra.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "peixe")
@Table(name = "peixe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Peixe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String especie;
    private Float reproducao;
    private Float valor;

    @OneToOne
    private Fornecedor fornecedor;
}
