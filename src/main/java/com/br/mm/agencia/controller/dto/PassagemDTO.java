package com.br.mm.agencia.controller.dto;

import java.time.LocalDateTime;

import com.br.mm.agencia.model.Passagem;

public class PassagemDTO {

  private Long id;
  private String origem;
  private String destino;
  private LocalDateTime dataCriacao;
  private String nomeCliente;
  private String nomeCompanhia;

  public PassagemDTO(Passagem passagem) {

    this.id = passagem.getId();
    this.origem = passagem.getOrigem();
    this.destino = passagem.getDestino();
    this.dataCriacao = passagem.getDataCriacao();
    this.nomeCliente = passagem.getCliente().getNome();
    this.nomeCompanhia = passagem.getCompanhia().getNome();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getNomeCliente() {
    return this.nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public String getNomeCompanhia() {
    return this.nomeCompanhia;
  }

  public void setNomeCompanhia(String nomeCompanhia) {
    this.nomeCompanhia = nomeCompanhia;
  }

}
