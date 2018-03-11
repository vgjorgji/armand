package com.armand.cms.web.admin.spring;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.armand.cms.web.admin.interceptor.SelectedWebsiteInterceptor;
import com.armand.cms.web.admin.model.Page;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AdminMvcConfiguration extends WebMvcConfigurerAdapter {

  private final SelectedWebsiteInterceptor selectedWebsiteInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(selectedWebsiteInterceptor);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    Arrays.stream(Page.values()).forEach(page -> registry.addViewController(page.getUrl()).setViewName(page.getView()));
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  }

}
