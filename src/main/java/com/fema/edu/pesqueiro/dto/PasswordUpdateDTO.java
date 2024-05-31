package com.fema.edu.pesqueiro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateDTO {

    UUID id;
    String password;
    String token;
}


