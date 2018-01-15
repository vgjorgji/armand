package com.armand.cms.web.spring;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;

import com.armand.cms.core.conf.Component;
import com.armand.cms.web.formatter.LocalTextFormatter;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public abstract class MvcConfiguration extends WebMvcConfigurerAdapter {

  private final LocalTextFormatter localTextFormatter;
  private final AbstractConfigurableTemplateResolver templateResolver;

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.setUseSuffixPatternMatch(false);
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    super.addFormatters(registry);
    registry.addFormatter(localTextFormatter);
  }

  @PostConstruct
  public void addAliases() {
    for (Component component : Component.values()) {
      templateResolver.addTemplateAlias(StringUtils.uncapitalize(component.name()) + "-learn",
          "component/learn/" + StringUtils.uncapitalize(component.name()) + "-learn");
    }
  }

}
