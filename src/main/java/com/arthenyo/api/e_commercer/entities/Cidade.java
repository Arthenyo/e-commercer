package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_cidades")
@SequenceGenerator(name = "seq_cidades", sequenceName = "seq_cidades", initialValue = 1, allocationSize = 1)
public class Cidade {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_cidades")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado_id",nullable = false)
    private Estado estado;

    public Cidade() {
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
