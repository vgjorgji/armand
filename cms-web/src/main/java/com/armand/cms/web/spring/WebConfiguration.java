package com.armand.cms.web.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.armand.cms.core.spring.CoreConfiguration;

@Configuration
@Import({CoreConfiguration.class, MvcConfiguration.class})
@ComponentScan({"com.armand.cms.web.*.formatter", "com.armand.cms.web.*.service"})
public abstract class WebConfiguration {

}
