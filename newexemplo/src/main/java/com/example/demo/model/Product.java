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
    private String nome;
    private String fabricante;
    private String categoria;
    private Float preco;
    
    public Product (){}
    public Product(Long id, String nome, String fabricante, String categoria, Float preco) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.categoria = categoria;
        this.preco = preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getFabricante() {
        return fabricante;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Float getPreco() {
        return preco;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
