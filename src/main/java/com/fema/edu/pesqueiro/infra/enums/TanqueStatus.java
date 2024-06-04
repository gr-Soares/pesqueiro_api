package com.fema.edu.pesqueiro.infra.enums;

public enum TanqueStatus {

    OK("ok"),
    CHEIO("cheio"),
    MANUTENCAO("manutenacao"),
    PARADO("parado");

    private final String status;

    TanqueStatus(String status) { this.status = status; }

    public String getStatus() { return status; }
}
