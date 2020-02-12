package com.eduit.javahibernate.laboratories.utils;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        mapClasess(configuration);

        configuration.setProperties(loadProperties());
        
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    private static void mapClasess(Configuration configuration) {
        configuration.addAnnotatedClass(com.eduit.javahibernate.laboratories.laboratory01.Auto.class);
        configuration.addAnnotatedClass(com.eduit.javahibernate.laboratories.laboratory02.Concesionaria.class);
    }

    private static Properties loadProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/javahibernate?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        prop.put("hibernate.connection.username", "root");
        prop.put("hibernate.connection.password", "admin");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.hbm2ddl.auto", "validate");
        
        return prop;
    }
}
