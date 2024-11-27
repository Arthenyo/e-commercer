package com.arthenyo.api.e_commercer.entities.enums;

public enum TipoEndereco {
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    COBRANCA("Cobranca");

    private String description;

    TipoEndereco(String description) {
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
