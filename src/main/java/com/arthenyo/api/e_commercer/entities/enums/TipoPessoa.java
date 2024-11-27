package com.arthenyo.api.e_commercer.entities.enums;

public enum TipoPessoa {
    FISICA("Física"),
    JURIDICA("Jurídica"),
    FORNECEDOR("Fornecedor"),
    CLIENTE("Cliente"),
    EMPRESA("Empresa");

    private String description;

    TipoPessoa(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
