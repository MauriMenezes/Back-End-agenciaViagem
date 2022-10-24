package com.br.mm.agencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mm.agencia.model.Escala;

public interface EscalaRepository extends JpaRepository<Escala, Long> {

  List<Escala> findByOrigem(String origem);

}
