package com.jsolution.springbootfundamentals.c_port_path.configuration;

import com.jsolution.springbootfundamentals.c_port_path.interfaces.MyBeanWithProperties;
import com.jsolution.springbootfundamentals.c_port_path.interfaces.implementation.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, lastname, random);
    }
}
