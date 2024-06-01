package com.fema.edu.pesqueiro.infra.model;


import com.fema.edu.pesqueiro.infra.enums.ProdutoTipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "produto")
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;
    private Float valor_c;
    private Integer marca;
    private ProdutoTipo tipo;
    private Integer qtde;
    private Float valor_f;

    @OneToOne
    private FornecedorPagamento fornecedorPagamento;
    /*@OneToOne
    private Aluguel aluguel;
    @OneToOne
    private Marca marca;*/

}
