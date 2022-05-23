package org.glushchenko.emart.service;

import org.glushchenko.emart.dto.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> getProducts(String categoryName) {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1","glushchenko","glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT" +
                    "  p.id," +
                    "  p.model_number," +
                    "  c.name," +
                    "  p.price " +
                    "FROM products p, categories c " +
                    "WHERE " +
                    "  p.categories_id = c.id" +
                    "  AND c.name = '" + categoryName + "'");
            while (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getString(1));
                product.setModelNumber(resultSet.getString(2));
                product.setCategoryName(resultSet.getString(3));
                product.setPrice(resultSet.getBigDecimal(4));

                products.add(product);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }

}
