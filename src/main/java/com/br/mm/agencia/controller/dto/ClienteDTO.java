package com.br.mm.agencia.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.br.mm.agencia.model.Cliente;

public class ClienteDTO {

  private long id;
  private String CPF;
  private String nome;
  private String Email;
  private String senha;

  public ClienteDTO(Cliente cliente) {

    this.id = cliente.getId();
    this.CPF = cliente.getCPF();
    this.nome = cliente.getNome();
    this.Email = cliente.getEmail();
    this.senha = cliente.getSenha();
  }

  public ClienteDTO() {

  }

  public long getId() {
    return this.id;
  }

  public String getCPF() {
    return this.CPF;
  }

  public String getNome() {
    return this.nome;
  }

  public String getEmail() {
    return this.Email;
  }

  public String getSenha() {
    return this.senha;
  }

  public static List<ClienteDTO> converter(List<Cliente> cliente) {
    return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
  }

}
