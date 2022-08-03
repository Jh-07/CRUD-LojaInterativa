package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nomeDoProduto;
    private String nomeDoFabricante;
    private String categoria;
    private Float preco;
    
    public Product (){}
    public Product(Long id, String nomeDoProduto, String nomeDoFabricante, String categoria, Float preco) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.nomeDoFabricante = nomeDoFabricante;
        this.categoria = categoria;
        this.preco = preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getnomeDoFabricante() {
        return nomeDoFabricante;
    }
    public Long getId() {
        return id;
    }
    public String getNomeDoProduto() {
        return nomeDoProduto;
    }
    public Float getPreco() {
        return preco;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setnomeDoFabricante(String nomeDoFabricante) {
        this.nomeDoFabricante = nomeDoFabricante;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
