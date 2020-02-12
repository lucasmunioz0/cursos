package com.eduit.javaspring.clase1.config;

import com.eduit.javaspring.clase1.Conexion;
import com.eduit.javaspring.clase1.DataRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eduit.javaspring.clase1")
public class SpringConfig {

    @Bean(name = "mysqlConexion")
    public Conexion mysqlConexion(){
        return new Conexion("http://mysql", 3306);
    }

    @Bean(name="mongoConexion")
    public Conexion mongoConexion(){
        return new Conexion("http://mongo", 3307);
    }

    @Bean(name = "dataDocumentRepository")
    public DataRepository dataRepository(@Qualifier("mongoConexion") Conexion conexion){
        return new DataRepository(conexion);
    }
}
