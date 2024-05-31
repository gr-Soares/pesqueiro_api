package com.fema.edu.pesqueiro.infra.model;

import com.fema.edu.pesqueiro.infra.enums.ComandaStatus;
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

    @Enumerated(EnumType.STRING)
    private ComandaStatus status;
}
