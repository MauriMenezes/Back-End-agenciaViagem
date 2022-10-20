package com.br.mm.agencia.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.br.mm.agencia.model.Cliente;
import com.br.mm.agencia.repository.ClienteRepository;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

  private TokenService tokenService;
  private ClienteRepository clienteRepository;

  public AutenticacaoTokenFilter(TokenService tokenService, ClienteRepository clienteRepository) {
    this.tokenService = tokenService;
    this.clienteRepository = clienteRepository;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = recuperarToken(request);

    boolean valido = tokenService.isTokenValid(token);
    System.out.println(valido);
    if (valido) {

      autenticarCliente(token);
    }

    filterChain.doFilter(request, response);

  }

  private void autenticarCliente(String token) {

    Long idCliente = tokenService.getIdCliente(token);

    Cliente cliente = clienteRepository.findById(idCliente).get();

    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cliente, null,
        cliente.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);

  }

  private String recuperarToken(HttpServletRequest request) {

    String token = request.getHeader("Authorization");

    if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
      System.out.println("AQUI TBM");
      return null;
    } else {
      return token.substring(7, token.length());
    }
  }

}
