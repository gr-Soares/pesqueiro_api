package com.fema.edu.pesqueiro.infra.enums;

public enum ProdutoTipo {

    COMPRA("compra"),
    ALUGUEL("aluguel");

    private final String tipo;

    ProdutoTipo(String status) {
        this.tipo = status;
    }

    public String getTipo() {
        return tipo;
    }
}
