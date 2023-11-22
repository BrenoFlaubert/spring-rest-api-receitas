package com.br.receitasapi.receitasapi.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "receitas")
@Getter
@Setter
public class Receita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String descricao;
  private String modoDePreparo;
  private String ingredientes;
  private String imgUrl;
  private String autor;
  @CreationTimestamp
  private LocalDateTime criadoEm;
  
  public Receita() {
  }

  public Receita(Long id, String nome, String descricao, String modoDePreparo, String ingredientes, String imgUrl,
    String autor, LocalDateTime criadoEm) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.modoDePreparo = modoDePreparo;
    this.ingredientes = ingredientes;
    this.imgUrl = imgUrl;
    this.autor = autor;
    this.criadoEm = criadoEm;
  }

}
