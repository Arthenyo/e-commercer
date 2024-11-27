package com.arthenyo.api.e_commercer.entities;

import com.arthenyo.api.e_commercer.entities.enums.TipoPessoa;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoas_fisica")
public class PessoaFisica extends Pessoa{
    @Column(nullable = false, unique = true)
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String email, String telefone, TipoPessoa tipoPessoa, Usuario usuario, Empresa empresa, String cpf) {
        super(nome, email, telefone, tipoPessoa, usuario, empresa);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
