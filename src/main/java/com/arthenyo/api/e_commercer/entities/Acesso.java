package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_acessos")
@SequenceGenerator(name = "seq_acessos", sequenceName = "seq_acessos", initialValue = 1, allocationSize = 1)
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acessos")
    private Long id;
    private String nome;

    public Acesso() {
    }

    public Acesso(String nome) {
        this.nome = nome;
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
}
