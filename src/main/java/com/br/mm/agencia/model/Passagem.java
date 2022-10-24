package com.br.mm.agencia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Passagem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  private Escala escala;
  @OneToOne
  private Companhia companhia;
  @OneToOne
  private Cliente cliente;

  public Passagem() {
  }

  public Passagem(Escala escala, Companhia companhia, Cliente cliente) {
    this.escala = escala;
    this.companhia = companhia;
    this.cliente = cliente;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Escala getEscala() {
    return this.escala;
  }

  public void setVoo(Escala escala) {
    this.escala = escala;
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
