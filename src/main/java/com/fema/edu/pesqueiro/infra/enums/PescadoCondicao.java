package com.fema.edu.pesqueiro.infra.enums;

public enum PescadoCondicao {

    VIVO("vivo"),
    MORTO("morto");

    private final String condicao;

    PescadoCondicao(String condicao) { this.condicao = condicao; }

    public String getCondicao() { return condicao; }
}
