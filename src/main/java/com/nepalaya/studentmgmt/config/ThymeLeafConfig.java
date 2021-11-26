package com.nepalaya.studentmgmt.config;

import nz.net.ultraq.web.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.dialect.SpringStandardDialect;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ThymeLeafConfig {

    @Value("${spring.ui.thyme.prefix}")
    private String viewPrefix;
    @Value("${spring.ui.thyme.suffix}")
    private String viewSuffix;
    @Value("${spring.ui.thyme.encoding}")
    private String viewEncoding;
    @Value("${spring.ui.thyme.templateMode}")
    private String viewTemplateMode;
    @Value("${spring.ui.thyme.cacheable}")
    private Boolean viewCacheable;

    @Bean
    public Set<IDialect> thymeleafDialects() {
        Set<IDialect> dialects = new HashSet<IDialect>();
        dialects.add(new SpringStandardDialect());
        dialects.add(new LayoutDialect());
        return dialects;
    }

    @Bean
    public SpringTemplateEngine templateEngine(
            ServletContextTemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        engine.setDialects(thymeleafDialects());
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(
            SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding(viewEncoding);
        return resolver;
    }

    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix(viewPrefix);
        resolver.setSuffix(viewSuffix);
        resolver.setTemplateMode(viewTemplateMode);
        resolver.setCacheable(viewCacheable);
        return resolver;
    }
}
