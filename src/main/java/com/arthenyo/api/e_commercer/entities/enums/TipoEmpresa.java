package com.arthenyo.api.e_commercer.entities.enums;

public enum TipoEmpresa {
    SEDE("Sede"),
    FILIAL("Filial");
    private String description;
    TipoEmpresa(String description) {
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
