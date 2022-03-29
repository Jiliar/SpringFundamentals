package com.jsolution.springbootfundamentals.f_jpa_modeling.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connections.properties")
public class H2Configuration {

    @Value("${spring.jpa.database-platform}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource(){

        return DataSourceBuilder.create()
                                .driverClassName(driverClassName)
                                .url(url)
                                .username(username)
                                .password(password)
                                .build();
    }
}
