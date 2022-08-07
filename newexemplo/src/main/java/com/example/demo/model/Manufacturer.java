package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manufacturer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nomeDoFabricante;
    private String categoria1;
    private String categoria2;
    private String categoria3;

    public Manufacturer(){}
    
    public Manufacturer(Long id, String nomeDoFabricante, String categoria1, String categoria2, String categoria3) {
        this.id = id;
        this.nomeDoFabricante = nomeDoFabricante;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
        this.categoria3 = categoria3;
    }
    public String getCategoria1() {
        return categoria1;
    }
    public void setCategoria1(String categoria1) {
        this.categoria1 = categoria1;
    }
    public String getCategoria2() {
        return categoria2;
    }
    public void setCategoria2(String categoria2) {
        this.categoria2 = categoria2;
    }
    public String getCategoria3() {
        return categoria3;
    }
    public void setCategoria3(String categoria3) {
        this.categoria3 = categoria3;
    }

   public String getNomeDoFabricante(){
    return this.nomeDoFabricante;
   }
   public void setNomeDoProduto(String nomeDoFabricante){
    this.nomeDoFabricante = nomeDoFabricante;
   }

   public Long getId(){
    return this.id;
   }
   public void setId(Long id){
    this.id=id;
   }
    
}
