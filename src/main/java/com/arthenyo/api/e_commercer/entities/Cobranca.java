package com.arthenyo.api.e_commercer.entities;

import com.arthenyo.api.e_commercer.entities.enums.MeioPagamento;
import com.arthenyo.api.e_commercer.entities.enums.StatusCobranca;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_cobranca")
@SequenceGenerator(name = "seq_cobranca", sequenceName = "seq_cobranca", allocationSize = 1, initialValue = 1)
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cobranca")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(nullable = false)
    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusCobranca statusCobranca;

    @Enumerated(EnumType.STRING)
    private MeioPagamento meioPagamento;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataEmissao;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataVencimento;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataPagamento;

    private String codigoTransacao;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Cobranca() {
    }

    public Cobranca(Pedido pedido, Double valorTotal, StatusCobranca statusCobranca, MeioPagamento meioPagamento, Instant dataEmissao, Instant dataVencimento, Instant dataPagamento, String codigoTransacao, Empresa empresa) {
        this.pedido = pedido;
        this.valorTotal = valorTotal;
        this.statusCobranca = statusCobranca;
        this.meioPagamento = meioPagamento;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.codigoTransacao = codigoTransacao;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusCobranca getStatusCobranca() {
        return statusCobranca;
    }

    public void setStatusCobranca(StatusCobranca statusCobranca) {
        this.statusCobranca = statusCobranca;
    }

    public MeioPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(MeioPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public Instant getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Instant dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Instant getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Instant dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Instant getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Instant dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
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
        Cobranca cobranca = (Cobranca) o;
        return Objects.equals(id, cobranca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
