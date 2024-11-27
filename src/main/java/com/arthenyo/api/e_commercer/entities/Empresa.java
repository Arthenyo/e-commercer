package com.arthenyo.api.e_commercer.entities;

import com.arthenyo.api.e_commercer.entities.enums.TipoEmpresa;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_empresas")
@SequenceGenerator(name = "seq_empresas", sequenceName = "seq_empresas", allocationSize = 1, initialValue = 1)
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresas")
    private Long id;
    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false, unique = true)
    private String razaoSocial;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false, unique = true)
    private String insEstadual;
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;
    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Empresa empresaSede;

    public Empresa() {
    }

    public Empresa(String cnpj, String razaoSocial, String nomeFantasia, String insEstadual, TipoEmpresa tipoEmpresa, Empresa empresaSede) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.insEstadual = insEstadual;
        this.tipoEmpresa = tipoEmpresa;
        this.empresaSede = empresaSede;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public Empresa getEmpresaSede() {
        return empresaSede;
    }

    public void setEmpresaSede(Empresa empresaSede) {
        this.empresaSede = empresaSede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
