package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_estados")
@SequenceGenerator(name = "seq_estados", sequenceName = "seq_estados", initialValue = 1, allocationSize = 1)
public class Estado {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_estados")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String sigla;
    private Boolean ativo = false;

    public Estado() {
    }

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
