package com.eduit.javaspring.clase2.hibernate.enhanced;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.eduit.javaspring.clase2.hibernate.dao"})
public class PersistenceConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan("com.eduit.javaspring.clase2.hibernate.enhanced.model");
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/javaspringclase2he?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        ds.setUsername("root");
        ds.setPassword("admin");

        return ds;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory().getObject());
        return manager;
    }

    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty(Environment.HBM2DDL_AUTO, "create");

        return properties;
    }
}