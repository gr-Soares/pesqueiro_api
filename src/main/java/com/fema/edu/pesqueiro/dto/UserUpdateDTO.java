package com.fema.edu.pesqueiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    private UUID id;
    private String username;
    private String nome;
    private String email;
    private String celular;
    private float salario;
    private boolean active;

}
