package com.dmggg.curso_spring_crud_v3.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Product implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private String desc;
  private Double preco;
  private String imgUrl;

  public Product(Long id, String nome, Double preco, String imgUrl) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.imgUrl = imgUrl;
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getDesc() {
    return desc;
  }
  public void setDesc(String desc) {
    this.desc = desc;
  }
  public Double getPreco() {
    return preco;
  }
  public void setPreco(Double preco) {
    this.preco = preco;
  }
  public String getImgUrl() {
    return imgUrl;
  }
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  
}
