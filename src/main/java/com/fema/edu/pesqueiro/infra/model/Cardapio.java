package com.fema.edu.pesqueiro.infra.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "cardapio")
@Table(name = "cardapio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;

    @OneToOne
    private Franquia franquia;
}
