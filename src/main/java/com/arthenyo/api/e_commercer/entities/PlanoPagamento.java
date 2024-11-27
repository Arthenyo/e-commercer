package com.arthenyo.api.e_commercer.entities;

import com.arthenyo.api.e_commercer.entities.enums.TipoPlano;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_plano_pagamento")
@SequenceGenerator(name = "seq_plano_pagamento", sequenceName = "seq_plano_pagamento", allocationSize = 1, initialValue = 1)
public class PlanoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plano_pagamento")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPlano tipoPlano;

    private Integer numeroParcelas;

    private Double taxaJuros;

    private Double desconto;

    private Integer intervaloParcelas;

    @Column(columnDefinition = "TEXT")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public PlanoPagamento() {
    }

    public PlanoPagamento(TipoPlano tipoPlano, Integer numeroParcelas, Double taxaJuros, Double desconto, Integer intervaloParcelas, String descricao, Empresa empresa) {
        this.tipoPlano = tipoPlano;
        this.numeroParcelas = numeroParcelas;
        this.taxaJuros = taxaJuros;
        this.desconto = desconto;
        this.intervaloParcelas = intervaloParcelas;
        this.descricao = descricao;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(TipoPlano tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getIntervaloParcelas() {
        return intervaloParcelas;
    }

    public void setIntervaloParcelas(Integer intervaloParcelas) {
        this.intervaloParcelas = intervaloParcelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        PlanoPagamento that = (PlanoPagamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
