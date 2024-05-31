package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "clienteComanda")
@Table(name = "clienteComanda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClienteComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private float gasto;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    @OneToOne
    private Comanda comanda;

}
