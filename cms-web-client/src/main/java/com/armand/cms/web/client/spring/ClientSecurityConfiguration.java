package com.armand.cms.web.client.spring;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.armand.cms.web.filter.VisitorFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class ClientSecurityConfiguration extends WebSecurityConfigurerAdapter {

  public static final String LOGIN_PAGE_URL = "/login";

  private final UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.eraseCredentials(true)
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    String key = UUID.randomUUID().toString();
    http.anonymous()
        .key(key)
        .authenticationFilter(new VisitorFilter(key))
        .and()
        .formLogin()
        .loginPage(LOGIN_PAGE_URL).permitAll()
        .and()
        .logout()
        .logoutUrl("/logout").permitAll()
        .and()
        .authorizeRequests()
        .anyRequest().permitAll();
  }

}
