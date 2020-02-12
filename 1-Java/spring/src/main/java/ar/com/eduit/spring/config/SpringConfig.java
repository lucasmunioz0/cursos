package ar.com.eduit.spring.config;

import ar.com.eduit.spring.Conexion;
import ar.com.eduit.spring.DataRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ar.com.eduit.spring")
public class SpringConfig {

    @Bean(name="mysqlConexion")
    public Conexion mysqlConexion(){
        return new Conexion("http//mysql", 3306);
    }

    @Bean(name = "mongoConexion")
    public Conexion mongoConexion(){
        return new Conexion("http//mongo", 3306);
    }

    @Bean(name="dataDocumentRepository")
    public DataRepository dataDocumentRepository(@Qualifier("mongoConexion") Conexion mongoConexion){
        return new DataRepository(mongoConexion);
    }
}
