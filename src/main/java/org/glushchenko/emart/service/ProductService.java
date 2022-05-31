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

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT" +
                    "  p.id," +
                    "  p.model_number," +
                    "  c.name," +
                    "  p.warranty," +
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

    /*
     * input: one of the following:
     *      - stock number of the product
     *      - manufacturer of the product
     *      - model number
     *      - description attribute and/or value
     * output: a list of products satisfying the search criteria.
     * */
    public List<Product> getProductsByStockHelper(String productInfo) {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT" +
                    "  p.id," +
                    "  p.model_number," +
                    "  c.name," +
                    "  p.warranty," +
                    "  p.price " +
                    "FROM products p, categories c " +
                    "WHERE " +
                    "  p.categories_id = c.id" +
                    "  AND p.id = '" + productInfo + "'");

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

    public List<Product> getProductsByStock(String categoryName, String productInfo) {
        List<Product> products = new ArrayList<>();
        if (categoryName.equals("All") && !productInfo.isEmpty()) {
            // user didn't touch the category button, use getProductByInfo().
            return getProductsByStockHelper(productInfo);
        } else {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
                Statement statement = connection.createStatement();
                ResultSet resultSet;

                if (categoryName.equals("All")) {
                    // user did not touch the input text field
                    // nor the category dropdown.
                    // this means they want to see all products.
                    resultSet = statement.executeQuery("" +
                            "SELECT" +
                            "  p.id," +
                            "  p.model_number," +
                            "  c.name," +
                            "  p.warranty," +
                            "  p.price " +
                            "FROM products p, categories c " +
                            "WHERE " +
                            "  p.categories_id = c.id");
                } else if (productInfo.isEmpty()) {
                    // user selected some category but did not input
                    // specific product information.
                    // this means they want to see all products
                    // in that selected category.
                    resultSet = statement.executeQuery("" +
                            "SELECT" +
                            "  p.id," +
                            "  p.model_number," +
                            "  c.name," +
                            "  p.warranty," +
                            "  p.price " +
                            "FROM products p, categories c " +
                            "WHERE " +
                            "  p.categories_id = c.id" +
                            "  AND c.name = '" + categoryName + "'");
                } else {
                    // user selected a category AND put some text in the box.
                    resultSet = statement.executeQuery("" +
                            "SELECT" +
                            "  p.id," +
                            "  p.model_number," +
                            "  c.name," +
                            "  p.warranty," +
                            "  p.price " +
                            "FROM products p, categories c " +
                            "WHERE " +
                            "  p.categories_id = c.id" +
                            "  AND p.id = '" + productInfo + "'" +
                            "  AND c.name = '" + categoryName + "'");
                }


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
        }
        return products;
    }

    public List<Product> getProductsByModelHelper(String productInfo) {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT" +
                    "  p.id," +
                    "  p.model_number," +
                    "  c.name," +
                    "  p.warranty," +
                    "  p.price " +
                    "FROM products p, categories c " +
                    "WHERE " +
                    "  p.categories_id = c.id" +
                    "  AND p.model_number = '" + productInfo + "'");

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

    public List<Product> getProductsByModel(String categoryName, String productInfo) {
        List<Product> products = new ArrayList<>();
        if (categoryName.equals("All") && !productInfo.isEmpty()) {
            // user didn't touch the category button, use getProductByInfo().
            return getProductsByModelHelper(productInfo);
        } else {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
                Statement statement = connection.createStatement();
                ResultSet resultSet;

                if (categoryName.equals("All")) {
                    // user did not touch the input text field
                    // nor the category dropdown.
                    // this means they want to see all products.
                    resultSet = statement.executeQuery("" +
                            "SELECT" +
                            "  p.id," +
                            "  p.model_number," +
                            "  c.name," +
                            "  p.warranty," +
                            "  p.price " +
                            "FROM products p, categories c " +
                            "WHERE " +
                            "  p.categories_id = c.id");
                } else if (productInfo.isEmpty()) {
                    // user selected some category but did not input
                    // specific product information.
                    // this means they want to see all products
                    // in that selected category.
                    resultSet = statement.executeQuery("" +
                            "SELECT" +
                            "  p.id," +
                            "  p.model_number," +
                            "  c.name," +
                            "  p.warranty," +
                            "  p.price " +
                            "FROM products p, categories c " +
                            "WHERE " +
                            "  p.categories_id = c.id" +
                            "  AND c.name = '" + categoryName + "'");
                } else {
                    // user selected a category AND put some text in the box.
                    resultSet = statement.executeQuery("" +
                            "SELECT" +
                            "  p.id," +
                            "  p.model_number," +
                            "  c.name," +
                            "  p.warranty," +
                            "  p.price " +
                            "FROM products p, categories c " +
                            "WHERE " +
                            "  p.categories_id = c.id" +
                            "  AND p.model_number = '" + productInfo + "'" +
                            "  AND c.name = '" + categoryName + "'");
                }


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
        }
        return products;
    }
}