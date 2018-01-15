package com.armand.cms.web.client.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.armand.cms.web.client.interceptor.ClientVisitorInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ClientMvcConfiguration extends WebMvcConfigurerAdapter {

  private final ClientVisitorInterceptor clientVisitorInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(clientVisitorInterceptor);
  }

}
