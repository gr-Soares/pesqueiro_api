package com.fema.edu.pesqueiro.infra.model;

import com.fema.edu.pesqueiro.infra.enums.PescadoCondicao;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "pescado")
@Table(name = "pescado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pescado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private PescadoCondicao condicao;
    private String obs;

    @OneToOne
    private Comanda comanda;
    @OneToOne
    private ControlePeixe controlePeixe;
}
