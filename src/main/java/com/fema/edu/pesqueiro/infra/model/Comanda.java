package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "comanda")
@Table(name = "comanda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String status;
}
