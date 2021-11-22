package com.nepalaya.studentmgmt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nepalaya.studentmgmt")
@PropertySource(value = "/WEB-INF/application.properties")
public class AppConfig {

    @Value("${spring.ui.jsp.prefix}")
    private String viewPrefix;
    @Value("${spring.ui.jsp.suffix}")
    private String viewSuffix;
    @Value("${spring.jdbc.driverClassName}")
    private String driverClassName;
    @Value("${spring.jdbc.url}")
    private String url;
    @Value("${spring.jdbc.username}")
    private String username;
    @Value("${spring.jdbc.password}")
    private String password;

    @Bean
    public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setPrefix(viewPrefix);
        viewResolver.setSuffix(viewSuffix);
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
       return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
       return new JdbcTemplate(dataSource);
    }

}
