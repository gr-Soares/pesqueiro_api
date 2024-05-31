package com.fema.edu.pesqueiro.infra.model;

import com.fema.edu.pesqueiro.infra.enums.ComandaStatus;
import com.fema.edu.pesqueiro.infra.enums.HistComandaStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "historicoComanda")
@Table(name = "historicoComanda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class HistoricoComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private HistComandaStatus status;
    private float valor;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private String cpf;
    private String nota;

    @ManyToOne
    private Cliente cliente;

}
