package com.ar.eduit.javahibernate.clase3.manager;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionFactoryManager {
    public SessionFactoryManager() {
    }

    public static SessionFactory getSessionFactory() throws HibernateException{
        final Configuration config = new Configuration();
        registerMappers(config);

        config.setProperties(gethibernateProperties());

        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        SessionFactory sf = config.buildSessionFactory(builder.build());
        return sf;
    }

    private static Properties gethibernateProperties(){
        Properties prop = new Properties();

        prop.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/javahibernateclase3?serverTimezone=UTC");
        prop.put("hibernate.connection.username", "root");
        prop.put("hibernate.connection.password", "admin");
        prop.put("hibernate.hbm2ddl.auto", "create");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.put("hibernate.show_sql", "true");
        return prop;
    }

    private static void registerMappers(Configuration config){
        config.addAnnotatedClass(com.ar.eduit.javahibernate.clase3.entities.Cliente.class);
    }
}
