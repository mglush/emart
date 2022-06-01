package org.glushchenko.emart.service;

import org.glushchenko.emart.dto.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    /*
    * input: a string representing a valid category name.
    * output: a list of products for the given category.
    * */
    public List<Product> getProductsByCategory(String categoryName) {
        List<Product> products = new ArrayList<>();
        String query = "" +
                "SELECT" +
                "  p.id," +
                "  p.model_number," +
                "  c.name," +
                "  p.warranty," +
                "  p.price " +
                "FROM products p, categories c " +
                "WHERE " +
                "  p.categories_id = c.id";

        if (!categoryName.equals("All")) {
            query += "  AND c.name = '" + categoryName + "'";
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getString(1));
                product.setModelNumber(resultSet.getString(2));
                product.setCategoryName(resultSet.getString(3));
                product.setWarranty(resultSet.getBigDecimal(4));
                product.setPrice(resultSet.getBigDecimal(5));

                products.add(product);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }

    public List<Product> getProducts(String stockNumber, String categoryName, String modelNumber, String manufacturer, String attribute, String value) {
        List<Product> products = new ArrayList<>();
        String fromClause = "" +
                "SELECT" +
                "  p.id," +
                "  p.model_number," +
                "  c.name," +
                "  p.warranty," +
                "  p.price " +
                "FROM products p, categories c  ";
        String whereClause = "" +
                "WHERE " +
                "  p.categories_id = c.id";

        if (!stockNumber.isEmpty()) {
            whereClause += "" +
                    "  AND p.id = '" + stockNumber + "'";
        }
        if (!categoryName.equals("All")) {
            whereClause += "" +
                    "  AND c.name = '" + categoryName + "'";
        }
        if (!modelNumber.isEmpty()) {
            whereClause += "" +
                    "  AND p.model_number = '" + modelNumber + "'";
        }
        if (!manufacturer.isEmpty()) {
            fromClause += ", manufacturers m  ";
            whereClause += "" +
                    "  AND p.manufacturers_id = m.id" +
                    "  AND m.name = '" + manufacturer + "'";
        }
        if (!attribute.isEmpty()) {
            fromClause += ", product_attributes pa, product_attributes_values pav ";
            whereClause += "" +
                    "  AND pav.products_id = p.id" +
                    "  AND pav.product_attributes_id = pa.id" +
                    "  AND pa.name = '" + attribute + "'" +
                    "  AND pav.value = '" + value + "'";
        }

        String queryString = fromClause + whereClause;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getString(1));
                product.setModelNumber(resultSet.getString(2));
                product.setCategoryName(resultSet.getString(3));
                product.setWarranty(resultSet.getBigDecimal(4));
                product.setPrice(resultSet.getBigDecimal(5));

                products.add(product);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }
}