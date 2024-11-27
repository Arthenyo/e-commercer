package com.arthenyo.api.e_commercer.entities;

import com.arthenyo.api.e_commercer.entities.enums.StatusPagamento;
import com.arthenyo.api.e_commercer.entities.enums.StatusPedido;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
@SequenceGenerator(name = "seq_pedidos", sequenceName = "seq_pedidos", allocationSize = 1, initialValue = 1)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedidos")
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoPedido;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "plano_pagamento_id")
    private PlanoPagamento planoPagamento;

    @ManyToOne
    @JoinColumn(name = "cobranca_id")
    private Cobranca cobranca;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private PessoaFisica cliente;

    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PedidoItems> items = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    private Double valorTotal;

    private Double frete;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataEntregaPrevista;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataEnvio;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataConclusao;

    @Column(nullable = false, updatable = false)
    private Instant dataCriacao;

    private Instant dataAtualizacao;

    private String codigoRastreamento;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Pedido() {
    }

    public Pedido(String codigoPedido, Instant dataPedido, StatusPedido statusPedido, StatusPagamento statusPagamento,
                  PlanoPagamento planoPagamento, Cobranca cobranca, PessoaFisica cliente, Endereco enderecoEntrega,
                  Double valorTotal, Double frete, Instant dataEntregaPrevista, Instant dataEnvio, Instant dataConclusao,
                  String codigoRastreamento, Empresa empresa) {
        this.codigoPedido = codigoPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.statusPagamento = statusPagamento;
        this.planoPagamento = planoPagamento;
        this.cobranca = cobranca;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.valorTotal = valorTotal;
        this.frete = frete;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.dataEnvio = dataEnvio;
        this.dataConclusao = dataConclusao;
        this.codigoRastreamento = codigoRastreamento;
        this.empresa = empresa;
    }

    @PrePersist
    public void prePersist() {
        this.dataCriacao = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public PlanoPagamento getPlanoPagamento() {
        return planoPagamento;
    }

    public void setPlanoPagamento(PlanoPagamento planoPagamento) {
        this.planoPagamento = planoPagamento;
    }

    public Cobranca getCobranca() {
        return cobranca;
    }

    public void setCobranca(Cobranca cobranca) {
        this.cobranca = cobranca;
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }

    public Set<PedidoItems> getItems() {
        return items;
    }

    public void setItems(Set<PedidoItems> items) {
        this.items = items;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Instant getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public void setDataEntregaPrevista(Instant dataEntregaPrevista) {
        this.dataEntregaPrevista = dataEntregaPrevista;
    }

    public Instant getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Instant dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Instant getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Instant dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
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
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
