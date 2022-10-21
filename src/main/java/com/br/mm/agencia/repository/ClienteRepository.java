package com.br.mm.agencia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.mm.agencia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  Optional<Cliente> findByEmail(String email);

  Cliente findByNome(String nomeCliente);
}
