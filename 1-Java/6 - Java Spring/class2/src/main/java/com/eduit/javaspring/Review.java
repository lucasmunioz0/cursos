package com.eduit.javaspring;

import com.eduit.javaspring.beans.ContaduriaService;
import com.eduit.javaspring.beans.FacturacionService;
import com.eduit.javaspring.beans.impl.ContaduriaServiceImpl;
import com.eduit.javaspring.beans.impl.FacturacionServiceImpl;
import com.eduit.javaspring.config.MainConfiguration;
import com.eduit.javaspring.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Review {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        
//        ContaduriaService contaduriaService = new ContaduriaService();
//        contaduriaService.cierreDelDia();
//        ContaduriaService contaduriaService1 = new ContaduriaService();
//        contaduriaService1.cierreDelDia();
        ContaduriaService bean = context.getBean(ContaduriaServiceImpl.class);
        ContaduriaService bean2 = context.getBean(ContaduriaServiceImpl.class);
        bean.cierreDelDia();
        bean2.cierreDelDia();
        
        FacturacionService facturacionService = context.getBean("facturacion", FacturacionServiceImpl.class);
        facturacionService.ejecutar();
        
        System.out.println(bean == facturacionService.getService());
    }
}
