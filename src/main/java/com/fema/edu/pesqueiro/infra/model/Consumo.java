package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
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

    @ManyToOne
    private Comanda comanda;

    @ManyToOne
    private Produto produto;
}
