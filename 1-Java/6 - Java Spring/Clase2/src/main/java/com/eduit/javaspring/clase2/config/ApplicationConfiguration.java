package com.eduit.javaspring.clase2.config;

import com.eduit.javaspring.clase2.beans.impl.ContaduriaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eduit.javaspring.clase2")
public class ApplicationConfiguration {

    @Bean
    public ContaduriaServiceImpl contaduria(){
        return new ContaduriaServiceImpl();
    }
}
