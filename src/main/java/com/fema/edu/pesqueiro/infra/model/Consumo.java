package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "consumo")
@Table(name = "consumo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Float qtde;
    private Float valor;
    private LocalDateTime date;

    @OneToOne
    private Comanda comanda;
    @OneToOne
    private Produto produto;
}
