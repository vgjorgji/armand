package com.armand.cms.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.armand.cms.web.admin.spring.AdminConfiguration;

@Configuration
@EnableAutoConfiguration
@Import(AdminConfiguration.class)
public class AdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(AdminApplication.class, args);
  }

}
