package com.br.mm.agencia.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.mm.agencia.controller.dto.ClienteDTO;
import com.br.mm.agencia.controller.form.ClienteForm;
import com.br.mm.agencia.model.Cliente;
import com.br.mm.agencia.repository.ClienteRepository;

@Controller

@ResponseBody
@RequestMapping("/")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("/cliente")

  public String hello() {
    return "OLÁ";
  }

  @GetMapping("/listar")
  public List<ClienteDTO> lista() {
    List<Cliente> cli = clienteRepository.findAll();
    return ClienteDTO.converter(cli);
  }

  @GetMapping("/listar/{id}")
  public ClienteDTO detalhar(@PathVariable Long id) {
    Cliente cliente = clienteRepository.getReferenceById(id);
    return new ClienteDTO(cliente);
  }

  @DeleteMapping("/remove/{id}")
  public ResponseEntity<?> remove(@PathVariable Long id) {

    clienteRepository.deleteById(id);

    return ResponseEntity.ok().build();
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {

    Optional<Cliente> cli = clienteRepository.findByEmail(form.getEmail());

    if (cli.isPresent()) {
      return ResponseEntity.badRequest().build();
    } else {

      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      Cliente cliente = form.converter(encoder);
      clienteRepository.save(cliente);
      URI uri = uriBuilder.path("/agenda/cadastrar/{id}").buildAndExpand(cliente.getId()).toUri();
      return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

  }
}
