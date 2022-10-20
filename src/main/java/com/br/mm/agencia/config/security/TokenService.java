package com.br.mm.agencia.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.br.mm.agencia.model.Cliente;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

  @Value("${agencia.jwt.expiration}")
  private String expiration;

  @Value("${agencia.jwt.secret}")
  private String secret;

  public String gerarToken(Authentication authentication) {

    Cliente logado = (Cliente) authentication.getPrincipal();
    Date hoje = new Date();
    Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
    Long id = logado.getId();

    return Jwts.builder()
        .setIssuer("API MM'S")
        .setSubject(id.toString())
        .setIssuedAt(hoje)
        .setExpiration(dataExpiracao)
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();

  }

  public boolean isTokenValid(String token) {
    System.out.println(token);
    try {
      Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      System.out.println("AQUIaa");
      return false;

    }

  }

  public Long getIdCliente(String token) {

    Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    return Long.parseLong(claims.getSubject());

  }

}
