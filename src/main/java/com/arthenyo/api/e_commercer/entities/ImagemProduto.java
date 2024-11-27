package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_imagem_produto")
@SequenceGenerator(name = "seq_imagem_produto", sequenceName = "seq_imagem_produto", allocationSize = 1, initialValue = 1)
public class ImagemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_imagem_produto")
    private Long id;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Boolean isMiniatura;

    public ImagemProduto() {
    }

    public ImagemProduto(String url, Produto produto, Boolean isMiniatura) {
        this.url = url;
        this.produto = produto;
        this.isMiniatura = isMiniatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Boolean getMiniatura() {
        return isMiniatura;
    }

    public void setMiniatura(Boolean miniatura) {
        isMiniatura = miniatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagemProduto that = (ImagemProduto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
