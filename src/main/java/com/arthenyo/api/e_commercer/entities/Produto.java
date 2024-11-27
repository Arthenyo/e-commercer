package com.arthenyo.api.e_commercer.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_produtos")
@SequenceGenerator(name = "seq_produtos", sequenceName = "seq_produtos", allocationSize = 1, initialValue = 1)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String tipoUnidade;

    private Double peso;

    private Double largura;

    private Double altura;

    private Double profundidade;

    private Double qtdEstoque;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private PessoaJuridica fornecedor;

    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private Double precoAtual;

    @Column(nullable = false, updatable = false)
    private LocalDate dataCadastro;

    private LocalDate dataUltimaAtualizacao;

    private String codigoBarras;

    private Double estoqueMinimo;

    private Double estoqueMaximo;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoricoPreco> historicoPrecos = new ArrayList<>();
    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private ImagemProduto miniatura;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagemProduto> imagens = new ArrayList<>();

    public Produto() {
    }

    public Produto(String nome, String descricao, String tipoUnidade, Double peso, Double largura, Double altura, Double profundidade, Double qtdEstoque, Boolean ativo, PessoaJuridica fornecedor, Marca marca, Empresa empresa, Double precoAtual, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, String codigoBarras, Double estoqueMinimo, Double estoqueMaximo, ImagemProduto miniatura) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipoUnidade = tipoUnidade;
        this.peso = peso;
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
        this.qtdEstoque = qtdEstoque;
        this.ativo = ativo;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.empresa = empresa;
        this.precoAtual = precoAtual;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.codigoBarras = codigoBarras;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.miniatura = miniatura;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public Double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public PessoaJuridica getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(PessoaJuridica fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(Double precoAtual) {
        this.precoAtual = precoAtual;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Double getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(Double estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public List<HistoricoPreco> getHistoricoPrecos() {
        return historicoPrecos;
    }

    public void setHistoricoPrecos(List<HistoricoPreco> historicoPrecos) {
        this.historicoPrecos = historicoPrecos;
    }

    public ImagemProduto getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(ImagemProduto miniatura) {
        this.miniatura = miniatura;
    }

    public List<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemProduto> imagens) {
        this.imagens = imagens;
    }

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataUltimaAtualizacao = LocalDate.now();
    }
    public void alterarPreco(Double novoPreco) {
        if (this.precoAtual != null) {
            HistoricoPreco historico = new HistoricoPreco(this, this.precoAtual, LocalDate.now());
            this.historicoPrecos.add(historico);
        }
        this.precoAtual = novoPreco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
