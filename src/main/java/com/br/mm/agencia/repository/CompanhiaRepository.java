package com.br.mm.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mm.agencia.model.Companhia;

public interface CompanhiaRepository extends JpaRepository<Companhia, Long> {

  Companhia findByNome(String nomeCompanhia);
}
