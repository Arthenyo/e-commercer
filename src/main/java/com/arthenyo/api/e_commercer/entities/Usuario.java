package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuarios")
@SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", initialValue = 1, allocationSize = 1)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    private Long id;
    private String email;
    private String senha;
    @ManyToMany
    @JoinTable(name = "tb_usuario_acesso",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "acesso_id"))
    private Set<Acesso> acessos = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Acesso> getAcessos() {
        return acessos;
    }

    public void setAcessos(Set<Acesso> acessos) {
        this.acessos = acessos;
    }
}
