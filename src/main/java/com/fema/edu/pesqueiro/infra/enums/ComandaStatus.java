package com.fema.edu.pesqueiro.infra.enums;

public enum ComandaStatus {

    ABERTA("aberta"),
    DISPONIVEL("disponivel"),
    FECHADA("fechada");

    private final String status;

    ComandaStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
