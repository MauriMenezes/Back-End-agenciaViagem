package com.br.mm.agencia.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.br.mm.agencia.repository.ClienteRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private AutenticacaoService autenticacaoService;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  // CONFIG AUTENTICAÇÂO
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());

  }

  // CONFIG DE AUTORIZAÇÂO
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/listar").permitAll()
        .antMatchers(HttpMethod.POST, "/auth").permitAll()
        .antMatchers(HttpMethod.POST, "/cadastrar").permitAll()
        .antMatchers(HttpMethod.POST, "/passagem/*").permitAll()
        .anyRequest().authenticated()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, clienteRepository),
            UsernamePasswordAuthenticationFilter.class);

  }

  // CONFIG DE RECURSOS ESTATICOS
  @Override
  public void configure(WebSecurity web) throws Exception {

  }

}
