package com.eduit.javaseweb.integrator.version3;

import com.eduit.javaseweb.integrator.dao.ProductDao;
import com.eduit.javaseweb.integrator.models.Product;
import java.sql.SQLException;
import java.util.List;

public class IntegratorVersion3 {
    public static void main(String[] args) throws SQLException {
        List<Product> products = new ProductDao().getAll();
        System.out.println(products);
    }
}
