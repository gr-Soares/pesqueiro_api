package com.fema.edu.pesqueiro.infra.enums;

public enum UserRole {
    ROOT("root"),
    ADMIN("gestao"),
    USER("funcionario");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
