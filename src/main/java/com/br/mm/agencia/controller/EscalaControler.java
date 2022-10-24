package com.br.mm.agencia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.mm.agencia.controller.form.EscalaForm;
import com.br.mm.agencia.model.Escala;
import com.br.mm.agencia.repository.EscalaRepository;

import net.bytebuddy.asm.Advice.Return;

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

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody EscalaForm form) {

    Escala escala = new Escala(form.getOrigem(), form.getDestino());

    escalaRepository.save(escala);

    return ResponseEntity.ok().body(escala);

  }

}
