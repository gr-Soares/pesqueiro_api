package com.fema.edu.pesqueiro.infra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fema.edu.pesqueiro.infra.enums.TanqueStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity(name = "tanque")
@Table(name = "tanque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tanque {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;
    private Integer capacidade;
    private TanqueStatus status;

    /*@OneToOne
    private Franquia franquia;*/
}
