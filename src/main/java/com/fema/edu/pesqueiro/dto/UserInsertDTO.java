package com.fema.edu.pesqueiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInsertDTO {

    private String username;
    private String password;
    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private float salario;

}
