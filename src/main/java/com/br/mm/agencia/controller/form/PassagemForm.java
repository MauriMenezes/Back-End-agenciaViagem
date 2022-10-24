package com.br.mm.agencia.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.mm.agencia.model.Cliente;
import com.br.mm.agencia.model.Companhia;
import com.br.mm.agencia.model.Passagem;
import com.br.mm.agencia.model.Escala;
import com.br.mm.agencia.repository.ClienteRepository;
import com.br.mm.agencia.repository.CompanhiaRepository;
import com.br.mm.agencia.repository.EscalaRepository;

public class PassagemForm {

  private long escala;
  @NotNull
  @NotEmpty
  private String companhia;
  @NotNull
  @NotEmpty
  private String cliente;

  public long getescala() {
    return this.escala;
  }

  public void setEscala(long escala) {
    this.escala = escala;
  }

  public String getCompanhia() {
    return this.companhia;
  }

  public void setCompanhia(String companhia) {
    this.companhia = companhia;
  }

  public String getCliente() {
    return this.cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Passagem converter(ClienteRepository clienteRepository, CompanhiaRepository companhiaRepository,
      EscalaRepository escalaRepository) {

    Cliente nomeCli = clienteRepository.findByNome(cliente);
    Companhia nomeComp = companhiaRepository.findByNome(companhia);
    Escala escalaId = escalaRepository.getReferenceById(escala);

    System.out.println(nomeComp.getNome());
    System.out.println(nomeCli.getNome());
    System.out.println("origem" + escalaId.getOrigem());
    System.out.println("destino" + escalaId.getDestino());

    return new Passagem(escalaId, nomeComp, nomeCli);
  }

}
