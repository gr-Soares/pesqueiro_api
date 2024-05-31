package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "historicoComanda")
@Table(name = "historicoComanda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String status;
    private float valor;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private String cpf;
    private String nota;

    @ManyToOne
    private Cliente cliente;

}
