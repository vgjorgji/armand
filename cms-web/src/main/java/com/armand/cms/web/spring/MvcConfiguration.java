package com.armand.cms.web.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.armand.cms.web.formatter.LocalTextFormatter;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public abstract class MvcConfiguration extends WebMvcConfigurerAdapter {

  private final LocalTextFormatter localTextFormatter;

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.setUseSuffixPatternMatch(false);
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    super.addFormatters(registry);
    registry.addFormatter(localTextFormatter);
  }

}
