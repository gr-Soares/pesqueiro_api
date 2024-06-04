package com.fema.edu.pesqueiro.infra.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
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

    @ManyToOne
    private Fornecedor fornecedor;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tanque> tanques;
}
