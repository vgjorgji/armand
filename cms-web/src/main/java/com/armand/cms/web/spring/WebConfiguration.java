package com.armand.cms.web.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.armand.cms.core.spring.CoreConfiguration;
import com.armand.cms.web.formatter.WebFormatters;

@Configuration
@Import({CoreConfiguration.class, MvcConfiguration.class})
@ComponentScan(basePackageClasses = WebFormatters.class)
public abstract class WebConfiguration {

}
