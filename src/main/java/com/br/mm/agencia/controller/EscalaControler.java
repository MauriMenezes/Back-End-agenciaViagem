package com.br.mm.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.mm.agencia.model.Escala;
import com.br.mm.agencia.repository.EscalaRepository;

@Controller
@ResponseBody
@RequestMapping("/escala")
public class EscalaControler {

  @Autowired
  EscalaRepository escalaRepository;

  @GetMapping("/listar/{origem}")
  public List<Escala> lista(@PathVariable String origem) {

    List<Escala> list = escalaRepository.findByOrigem(origem);

    return list;
  }

}
