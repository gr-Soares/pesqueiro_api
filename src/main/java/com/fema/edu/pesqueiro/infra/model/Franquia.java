package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "franquia")
@Table(name = "franquia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Franquia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String endereco;
    private String cep;
    private Character uf;
    private String nome;
}
