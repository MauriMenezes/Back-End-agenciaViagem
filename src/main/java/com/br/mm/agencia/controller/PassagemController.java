package com.br.mm.agencia.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.mm.agencia.controller.dto.PassagemDTO;
import com.br.mm.agencia.controller.form.PassagemForm;
import com.br.mm.agencia.model.Passagem;
import com.br.mm.agencia.repository.ClienteRepository;
import com.br.mm.agencia.repository.CompanhiaRepository;
import com.br.mm.agencia.repository.PassagemRepository;

@Controller
@ResponseBody
@RequestMapping("/passagem")
public class PassagemController {

  @Autowired
  PassagemRepository passagemRepository;
  @Autowired
  ClienteRepository clienteRepository;
  @Autowired
  CompanhiaRepository companhiaRepository;

  @PostMapping("/cadastrar")
  public ResponseEntity<PassagemDTO> cadastrar(@RequestBody @Valid PassagemForm form, UriComponentsBuilder uriBuilder) {

    Passagem passagem = form.converter(clienteRepository, companhiaRepository);
    passagemRepository.save(passagem);

    URI uri = uriBuilder.path("/cadastrar").buildAndExpand(passagem.getId()).toUri();

    return ResponseEntity.created(uri).body(new PassagemDTO(passagem));

  }
}
