package com.fema.edu.pesqueiro.infra.enums;

public enum FornecedorPagamentoStatus {

    PAGO("pago"),
    DEVENDO("devendo");

    private final String status;

    FornecedorPagamentoStatus(String status) { this.status = status; }

    public String getStatus() { return status; }

}
