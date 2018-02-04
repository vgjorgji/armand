package com.armand.cms.web.admin.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.armand.cms.web.admin.interceptor.SelectedWebsiteInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AdminMvcConfiguration extends WebMvcConfigurerAdapter {

  private final SelectedWebsiteInterceptor selectedWebsiteInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(selectedWebsiteInterceptor);
  }

}
