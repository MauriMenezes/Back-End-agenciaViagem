package com.br.mm.agencia.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passagem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private LocalDateTime dataCriacao = LocalDateTime.now();
  private String Origem;
  private String Destino;
  @OneToOne
  private Companhia companhia;
  @OneToOne
  private Cliente cliente;

  public Passagem() {
  }

  public Passagem(String Origem, String Destino, Companhia companhia,
      Cliente cliente) {

    this.Origem = Origem;
    this.Destino = Destino;
    this.companhia = companhia;
    this.cliente = cliente;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDateTime getDataCriacao() {
    return this.dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public String getOrigem() {
    return this.Origem;
  }

  public void setOrigem(String Origem) {
    this.Origem = Origem;
  }

  public String getDestino() {
    return this.Destino;
  }

  public void setDestino(String Destino) {
    this.Destino = Destino;
  }

  public Companhia getCompanhia() {
    return this.companhia;
  }

  public void setCompanhia(Companhia companhia) {
    this.companhia = companhia;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

}
