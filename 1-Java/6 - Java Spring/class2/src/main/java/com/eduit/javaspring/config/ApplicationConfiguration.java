package com.eduit.javaspring.config;

import com.eduit.javaspring.beans.ContaduriaService;
import com.eduit.javaspring.beans.FacturacionService;
import com.eduit.javaspring.beans.impl.ContaduriaServiceImpl;
import com.eduit.javaspring.beans.impl.FacturacionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    
    @Bean
    public ContaduriaService contaduria(){
        return new ContaduriaServiceImpl();
    }
    
//    @Bean
//    public FacturacionService facturacionService(){
//        return new FacturacionServiceImpl(contaduria());
//    }
}
