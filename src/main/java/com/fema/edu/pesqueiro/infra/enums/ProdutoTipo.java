package com.fema.edu.pesqueiro.infra.enums;

public enum ProdutoTipo {

    COMIDA("comida"),
    BEBIDA("bebida"),
    PEIXE("peixe");

    private final String tipo;

    ProdutoTipo(String status) {
        this.tipo = status;
    }

    public String getTipo() {
        return tipo;
    }
}
