package com.fema.edu.pesqueiro.infra.model;

import com.fema.edu.pesqueiro.infra.enums.TanqueStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "tanque")
@Table(name = "tanque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "if")
public class Tanque {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Float capacidade;
    private TanqueStatus status;

    /*@OneToOne
    private Franquia franquia;*/
}
