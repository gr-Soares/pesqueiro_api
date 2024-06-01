package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "controlePeixe")
@Table(name = "controlePeixe")
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

    @OneToOne
    private Peixe peixe;
    @OneToOne
    private Tanque tanque;
}