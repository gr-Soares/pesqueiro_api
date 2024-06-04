package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "controle_peixe")
@Table(name = "controle_peixe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ControlePeixe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer qtde;

    @ManyToOne
    private Peixe peixe;
    @ManyToOne
    private Tanque tanque;
}