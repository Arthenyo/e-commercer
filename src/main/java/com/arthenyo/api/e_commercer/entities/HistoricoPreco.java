package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_historico_preco")
@SequenceGenerator(name = "seq_historico_preco", sequenceName = "seq_historico_preco", allocationSize = 1, initialValue = 1)
public class HistoricoPreco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historico_preco")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    private Double precoAnterior;

    private LocalDate dataAlteracao;

    public HistoricoPreco() {
    }

    public HistoricoPreco(Produto produto, Double precoAnterior, LocalDate dataAlteracao) {
        this.produto = produto;
        this.precoAnterior = precoAnterior;
        this.dataAlteracao = dataAlteracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoAnterior(Double precoAnterior) {
        this.precoAnterior = precoAnterior;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoPreco that = (HistoricoPreco) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
