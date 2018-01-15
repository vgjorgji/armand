package com.armand.cms.web.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.armand.cms.web.client.spring.ClientConfiguration;

@Configuration
@EnableAutoConfiguration
@Import(ClientConfiguration.class)
public class ClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
  }

}