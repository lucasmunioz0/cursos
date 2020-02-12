package com.eduit.javaspring.hibernate.enhanced;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.eduit.javaspring.hibernate.dao"})
public class PersistenceConfig {
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setHibernateProperties(hibernateProperties());
        bean.setPackagesToScan("com.eduit.javaspring.hibernate.enhanced.model");
        return bean;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/hibernate_spring?useSSL=false&serverTimezone=UTC");
        dmds.setUsername("root");
        dmds.setPassword("admin");
        
        return dmds;
    }
    
    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory().getObject());
        
        return manager;
    }
    
    public Properties hibernateProperties(){
        Properties p = new Properties();
        p.setProperty("hibernate.hbm2ddl.auto", "create");
        p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        
        return p;
    }
}
