package com.eduit.javahibernate.classroom1;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    public static Session getSession() throws HibernateException{
        Configuration config = new Configuration();
        registerMappers(config);
        config.setProperties(getHibernateProperties());
        
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        
        SessionFactory factory = config.buildSessionFactory();
        
        return factory.openSession();
    }

    private static void registerMappers(Configuration config) {
        config.addAnnotatedClass(com.eduit.javahibernate.classroom1.Car.class);
    }

    private static Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/javahibernate?useSSL=false&serverTimezone=UTC");
        prop.put("hibernate.connection.username", "root");
        prop.put("hibernate.connection.password", "admin");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.hbm2ddl.auto", "update");
        
        return prop;
    }
}
