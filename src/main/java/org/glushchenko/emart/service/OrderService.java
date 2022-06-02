package org.glushchenko.emart.service;

import org.glushchenko.emart.dto.Order;
import org.glushchenko.emart.dto.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public Order createNewOrder(String customerID) {
        Order order = new Order();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT count(*) " +
                    " FROM orders"
                    );
            resultSet.next();
            String orderID = resultSet.getString(1);
            System.out.println("\n\ncount of orders query returned : " + orderID + "\n\n");

            resultSet = statement.executeQuery("" +
                    "INSERT INTO" +
                    "  orders (" +
                    "  id," +
                    "  customers_id)" +
                    " VALUES (" +
                    "'" + orderID + "'," +
                    "'" + customerID + "')");

            order.setId(orderID);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return order;
    }

    public Order getLastOrder(String customerID) {
        Order order = new Order();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT MAX(id) " +
                    "FROM orders " +
                    "WHERE " +
                    "  customers_id = '" + customerID + "'" +
                    "  AND checked_out_at is null");
            if (resultSet.next() && resultSet.getString(1) != null) {
                order.setId(resultSet.getString(1));
            } else {
                System.out.println("\n\ndid not return jack shit aboutta create new order\n\n");
                order = createNewOrder(customerID);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return order;
    }

    public List<Product> displayOrderLinesContents(String orderNumber) {
        List<Product> products = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT products_id, " +
                    "  price, " +
                    "  count " +
                    "FROM order_lines " +
                    "WHERE " +
                    "  orders_id = " + orderNumber);

            while (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getString(1));
                product.setPrice(resultSet.getBigDecimal(2));
                product.setWarranty(resultSet.getBigDecimal(3));

                products.add(product);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }

    public void addProductToOrder(String orderNumber, String stockNumber, String count) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();

            ProductService productService = new ProductService();
            List<Product> products = productService.getProducts(stockNumber, "All", "", "", "", "");
            String price = products.get(0).getPrice().toString();

            ResultSet resultSet = statement.executeQuery("" +
                    "INSERT INTO " +
                    "  order_lines(" +
                    "  orders_id, " +
                    "  products_id, " +
                    "  created_at, " +
                    "  price, " +
                    "  count) " +
                    "VALUES(" +
                    "'" + orderNumber + "', " +
                    "'" + stockNumber + "', " +
                    LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + ", " +
                    price + ", " +
                    count + ")");

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Float getOrderSubtotal(String orderNumber) {
        Float result = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT SUM(result) " +
                    "  FROM " +
                    "           (SELECT price*count AS result " +
                    "            FROM order_lines " +
                    "            WHERE orders_id = " + orderNumber + ")");

            resultSet.next();
            result = resultSet.getFloat(1);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    public Float getOrderTotal(String orderNumber) {
        Float result = getOrderSubtotal(orderNumber);
        // query customer database for customer status, query policy table for policy.
        // apply discount and shipping and handling as policy indicates.
        return result;
    }

    public Boolean confirmOrder(String orderNumber) {
        // gonna do this when doing the checkout servlet.
        // query matthew's inventory to make sure we have enough items.

        // add current time to "checked_out_at" member of the order to finalize the order.

        return true;
    }
}