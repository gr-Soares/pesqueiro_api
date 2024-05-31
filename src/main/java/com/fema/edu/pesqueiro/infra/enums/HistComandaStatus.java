package com.fema.edu.pesqueiro.infra.enums;

public enum HistComandaStatus {

    PAGO("pago"),
    DEVENDO("devendo");

    private final String status;

    HistComandaStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
