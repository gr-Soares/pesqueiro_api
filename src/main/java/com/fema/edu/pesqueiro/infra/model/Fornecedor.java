package com.fema.edu.pesqueiro.infra.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity(name = "fornecedor")
@Table(name = "fornecedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String cnpj;
    private String email;
    private String telefone;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "fornecedor_id")
    private Set<Marca> marcas;
}
