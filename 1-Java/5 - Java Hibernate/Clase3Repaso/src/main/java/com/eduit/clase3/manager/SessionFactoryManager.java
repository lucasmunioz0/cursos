package com.eduit.clase3.manager;

import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryManager {
    private static SessionFactoryManager instance;
    private final SessionFactory sf;
    
    private SessionFactoryManager(){
        Configuration cfg = new Configuration();
        registerMappers(cfg);
        cfg.setProperties(getProperties());
        
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        sf = cfg.buildSessionFactory(builder.build());
    }
    
    public static SessionFactory getSessionFactory(){
        if(instance == null || instance.getSf().isClosed()){
            instance = new SessionFactoryManager();
        }
        
        return instance.sf;
    }
    
    private static Properties getProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/jhclase3?serverTimezone=UTC");
        properties.put("hibernate.connection.user", "root");
        properties.put("hibernate.connection.password", "admin");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        
        return properties;
    }
    
    private static void registerMappers(Configuration config){
        config.addAnnotatedClass(com.eduit.clase3.entities.Cliente.class);
    }
    
    private SessionFactory getSf(){
        return sf;
    }
}
