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

    public Boolean checkOrderConfirmation(String orderID) {
        Boolean result;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT checked_out_at " +
                    "FROM orders " +
                    "WHERE " +
                    "  id = '" + orderID + "'");

            resultSet.next();
            if (resultSet.getString(1).isEmpty() || resultSet.getString(1) == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
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

    public Order getOrderByID(String orderNumber) {
        Order order = new Order();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT id, " +
                    "  discount, " +
                    "  shipping_and_handling, " +
                    "  checked_out_at, " +
                    "  total " +
                    "FROM orders " +
                    "WHERE " +
                    "  id = " + orderNumber);

            resultSet.next();
            order.setId(resultSet.getString(1));
            order.setDiscount(resultSet.getString(2));
            order.setShipping_and_handling(resultSet.getString(3));
            order.setChecked_out_at(resultSet.getString(4));
            order.setTotal(resultSet.getString(5));

        } catch (Exception e) {
            System.out.println(e);
        }

        return order;
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

    public void removeProductFromOrder(String orderNumber, String stockNumber) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "DELETE FROM order_lines " +
                    "WHERE orders_id = '" + orderNumber + "'" +
                    "  AND products_id = '" + stockNumber + "'");

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

    public int getProductCountInOrder(String orderNumber, String productID) {
        int result = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT count " +
                    "FROM order_lines " +
                    "WHERE orders_id = '" + orderNumber + "'" +
                    "  AND products_id = '" + productID + "'");

            resultSet.next();
            result = resultSet.getInt(1);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    public Float getOrderTotal(String orderNumber, Float discount, Float shipping_and_handling) {
        Float result = getOrderSubtotal(orderNumber);
        return result + result*discount + result*shipping_and_handling;
    }

    public Order confirmOrder(String orderNumber, String customerID) {
        List<Product> products = displayOrderLinesContents(orderNumber);
        Order order = new Order();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet;
            String query = "" +
                    "SELECT status " +
                    "FROM customers " +
                    "WHERE id = '" + customerID + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            String status = resultSet.getString(1).toLowerCase();
            System.out.println("status: " + status);

            query = "" +
                "SELECT value " +
                "FROM pricing_rules " +
                "WHERE name = '" + status + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            Float discount = resultSet.getFloat(1);
            System.out.println("discount: " + discount.toString());

            query = "" +
                    "UPDATE orders " +
                    "SET discount = '" + discount.toString() + "' " +
                    "WHERE id = '" + orderNumber + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();

            query = "" +
                    "SELECT value " +
                    "FROM pricing_rules " +
                    "WHERE name = 'shipping_and_handling'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            Float shipping_and_handling = resultSet.getFloat(1);
            System.out.println("shipping_and_handling: " + shipping_and_handling.toString());

            query = "" +
                    "SELECT value " +
                    "FROM pricing_rules " +
                    "WHERE name = 'free_shipping_threshold'";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            Float threshold = resultSet.getFloat(1);
            System.out.println("threshold for free shipping: " + threshold.toString());

            if (getOrderSubtotal(orderNumber) > threshold) {
                shipping_and_handling = Float.valueOf(0);
            }

            query = "" +
                    "UPDATE orders " +
                    "SET shipping_and_handling = '" + shipping_and_handling.toString() + "' " +
                    "WHERE id = '" + orderNumber + "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();

            Float total = getOrderTotal(orderNumber, discount, shipping_and_handling);
            System.out.println("total: " + total.toString());
            query = "" +
                    "UPDATE orders " +
                    "SET total = '" + total.toString() + "' " +
                    "WHERE id = '" + orderNumber +
                    "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();

            Long time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
            System.out.println("time: " + time.toString());
            query = "" +
                    "UPDATE orders " +
                    "SET checked_out_at = '" +
                    time.toString()
                    + "' " +
                    "WHERE id = '" + orderNumber +
                    "'";
            resultSet = statement.executeQuery(query);
            resultSet.next();

            order.setId(orderNumber);
            order.setDiscount(discount.toString());
            order.setShipping_and_handling(shipping_and_handling.toString());
            order.setTotal(total.toString());
            order.setChecked_out_at(time.toString());

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return order;
    }
}
// insert code here to query matt's database to check inventory.
// inventory table currently empty, i'll uncomment dis section whenever its populated.
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "maragaw", "password");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet;
//            String query;
//
//            for (Product product : products) {
//                query = "SELECT qty " +
//                        "FROM inventory " +
//                        "WHERE item_id = '" +
//                        product.getId() + "'";
//                resultSet = statement.executeQuery(query);
//                resultSet.next();
//                // inventory check here.
//                if (product.getWarranty().compareTo(resultSet.getBigDecimal(1)) == 1) {
//                    throw(new Exception("WE ARE LOW ON PRODUCT #" + product.getId()));
//                }
//            }
//
//            connection.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        // decrement the quantities of each product in our list if we haven't thrown an error yet.
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "maragaw", "password");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet;
//            String query;
//
//            // update order_lines set count=count-1 where orders_id = 'AA00402';
//            for (Product product : products) {
//                query = "UPDATE inventory " +
//                        "SET qty=qty-" + product.getWarranty().toString() + " " +
//                        "WHERE item_id = '" +
//                        product.getId() + "'";
//                resultSet = statement.executeQuery(query);
//            }
//
//            connection.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
// fill in the rest of order information,
// i.e. checked_out_at, total, discount, shipping_and_handling.