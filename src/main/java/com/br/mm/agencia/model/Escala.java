package com.br.mm.agencia.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Escala {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  public String origem;
  public String destino;
  private LocalDateTime dataCriacao = LocalDateTime.now();

  public Escala() {
  }

  public Escala(String origem, String destino) {
    this.origem = origem;
    this.destino = destino;

  }

  public String getOrigem() {
    return this.origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return this.destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public LocalDateTime getDataCriacao() {
    return this.dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public Escala origem(String origem) {
    setOrigem(origem);
    return this;
  }

  public Escala destino(String destino) {
    setDestino(destino);
    return this;
  }

  public Escala dataCriacao(LocalDateTime dataCriacao) {
    setDataCriacao(dataCriacao);
    return this;
  }

}
