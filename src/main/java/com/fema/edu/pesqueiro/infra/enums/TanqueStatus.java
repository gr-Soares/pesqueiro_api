package com.fema.edu.pesqueiro.infra.enums;

public enum TanqueStatus {

    LIVRE("livre"),
    CHEIO("cheio");

    private final String status;

    TanqueStatus(String status) { this.status = status; }

    public String getStatus() { return status; }
}
