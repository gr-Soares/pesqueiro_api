package com.fema.edu.pesqueiro.dto;

import com.fema.edu.pesqueiro.infra.model.Comanda;
import com.fema.edu.pesqueiro.infra.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoDTO {

    private Float qtde;
    private Float valor;

    private Comanda comanda;
    private Produto produto;

}
