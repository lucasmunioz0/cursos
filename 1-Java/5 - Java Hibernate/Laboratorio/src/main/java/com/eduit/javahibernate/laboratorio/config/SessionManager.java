package com.eduit.javahibernate.laboratorio.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionManager {

    private static SessionFactory sessionFactory;
    public static synchronized SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            mapearClases(configuration);
            configuration.setProperties(cargarPropiedades());

            final StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }

    private static Properties cargarPropiedades() {
        final Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/javalaboratorio?serverTimezone=UTC");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "admin");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        return properties;
    }

    private static void mapearClases(Configuration configuration) {
        configuration.addAnnotatedClass(com.eduit.javahibernate.laboratorio.model.Auto.class);
        configuration.addAnnotatedClass(com.eduit.javahibernate.laboratorio.model.Concesionario.class);
    }
}
