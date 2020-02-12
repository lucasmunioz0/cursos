package com.eduit.javaspring.clase2;

import com.eduit.javaspring.clase2.beans.ContaduriaService;
import com.eduit.javaspring.clase2.beans.impl.ContaduriaServiceImpl;
import com.eduit.javaspring.clase2.beans.impl.FacturacionService;
import com.eduit.javaspring.clase2.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Repaso {
    public static void main(String[] args) {
        //Define como se va a configurar Spring.
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ContaduriaService contaduriaServiceImpl1 = context.getBean(ContaduriaServiceImpl.class);
        FacturacionService facturacionService = context.getBean("facturacion", FacturacionService.class);

        //contaduriaServiceImpl1.cierreDelDia();
        facturacionService.ejecutar();
    }
}
