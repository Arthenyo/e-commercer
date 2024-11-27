package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "tb_marcas")
@SequenceGenerator(name = "seq_marcas", sequenceName = "seq_marcas", allocationSize = 1, initialValue = 1)
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marcas")
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Marca() {
    }

    public Marca(String nome, Empresa empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
