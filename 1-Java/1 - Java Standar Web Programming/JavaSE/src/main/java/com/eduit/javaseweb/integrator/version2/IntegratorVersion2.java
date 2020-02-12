package com.eduit.javaseweb.integrator.version2;

import com.eduit.javaseweb.integrator.dao.ProductDao;
import com.eduit.javaseweb.integrator.models.Product;
import java.sql.SQLException;

public class IntegratorVersion2 {
    public static void main(String[] args) throws SQLException {
        Product product = new Product(2, 55.50, "Billetera");
        ProductDao productDao = new ProductDao();
        System.out.println(product);
        System.out.println("Insert...");
        productDao.insert(product);
        System.out.println("Insert succesful");
        System.out.println("Get by description");
        Product find = productDao.getByDescription(product);
        System.out.println(find);
        
        find.setDescription("Billetera virtual");
        System.out.println("Updating...");
        productDao.update(product);
        System.out.println(find);
        
        System.out.println("Deleting...");
        //productDao.delete(product);
        
    }
}
