package com.br.mm.agencia.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.mm.agencia.model.Cliente;
import com.br.mm.agencia.model.Companhia;
import com.br.mm.agencia.model.Passagem;
import com.br.mm.agencia.repository.ClienteRepository;
import com.br.mm.agencia.repository.CompanhiaRepository;

public class PassagemForm {

  @NotNull
  @NotEmpty

  private String Origem;
  @NotNull
  @NotEmpty
  private String Destino;
  @NotNull
  @NotEmpty
  private String companhiaNome;
  @NotNull
  @NotEmpty
  private String ClienteNome;

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

  public String getCompanhiaNome() {
    return this.companhiaNome;
  }

  public void setCompanhiaNome(String companhiaNome) {
    this.companhiaNome = companhiaNome;
  }

  public String getClienteNome() {
    return this.ClienteNome;
  }

  public void setClienteNome(String ClienteNome) {
    this.ClienteNome = ClienteNome;
  }

  public Passagem converter(ClienteRepository clienteRepository, CompanhiaRepository companhiaRepository) {

    Cliente cliente = clienteRepository.findByNome(ClienteNome);
    Companhia companhia = companhiaRepository.findByNome(companhiaNome);

    System.out.println(companhia.getNome());
    System.out.println(cliente.getNome());

    return new Passagem(Origem, Destino, companhia, cliente);
  }

}
