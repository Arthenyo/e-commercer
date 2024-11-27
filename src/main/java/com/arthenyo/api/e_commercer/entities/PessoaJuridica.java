package com.arthenyo.api.e_commercer.entities;

import com.arthenyo.api.e_commercer.entities.enums.TipoPessoa;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoas_juridica")
public class PessoaJuridica extends Pessoa{
    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false, unique = true)
    private String razaoSocial;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false, unique = true)
    private String insEstadual;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String email, String telefone, TipoPessoa tipoPessoa, Usuario usuario, Empresa empresa, String cnpj, String razaoSocial, String nomeFantasia, String insEstadual) {
        super(nome, email, telefone, tipoPessoa, usuario, empresa);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.insEstadual = insEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInsEstadual() {
        return insEstadual;
    }

    public void setInsEstadual(String insEstadual) {
        this.insEstadual = insEstadual;
    }
}
