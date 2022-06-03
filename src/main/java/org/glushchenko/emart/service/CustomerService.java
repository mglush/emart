package org.glushchenko.emart.service;

import org.glushchenko.emart.dto.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerService {

    public Customer authenticateLogin(String email, String password) {
        Customer customer = new Customer();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT" +
                    "  c.id," +
                    "  c.name," +
                    "  c.email," +
                    "  c.address," +
                    "  c.customer_type, " +
                    "  c.status " +
                    "FROM customers c " +
                    "WHERE " +
                    "  c.email = '" + email + "'" +
                    "  AND c.password = '" + password + "'");
            while (resultSet.next()) {
                customer.setId(resultSet.getString(1));
                customer.setName(resultSet.getString(2));
                customer.setEmail(resultSet.getString(3));
                customer.setAddress(resultSet.getString(4));
                customer.setCustomerType(resultSet.getInt(5));
                customer.setStatus(resultSet.getString(6));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    public Customer createCustomer(String id, String password, String name, String email, String address) {
        Customer customer = new Customer();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "INSERT INTO" +
                    "  customers (" +
                    "  id," +
                    "  password," +
                    "  name," +
                    "  email," +
                    "  address," +
                    "  customer_type," +
                    "  status)" +
                    " VALUES (" +
                    "'" + id + "'," +
                    "'" + password + "'," +
                    "'" + name + "'," +
                    "'" + email + "'," +
                    "'" + address + "'," +
                    "1," +
                    "'New')");

            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setCustomerType(1);
            customer.setStatus("New");

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    public Customer getCustomerByID(String customerID) {
        Customer customer = new Customer();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT" +
                    "  c.id," +
                    "  c.name," +
                    "  c.email," +
                    "  c.address," +
                    "  c.customer_type, " +
                    "  c.status " +
                    "FROM customers c " +
                    "WHERE " +
                    "  c.id = '" + customerID + "'");
            while (resultSet.next()) {
                customer.setId(resultSet.getString(1));
                customer.setName(resultSet.getString(2));
                customer.setEmail(resultSet.getString(3));
                customer.setAddress(resultSet.getString(4));
                customer.setCustomerType(resultSet.getInt(5));
                customer.setStatus(resultSet.getString(6));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;
    }

    public void changeCustomerStatus(String customerID, String newStatus) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "glushchenko", "glushDatabase");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("" +
                    "UPDATE customers " +
                    "SET status = '" + newStatus + "' " +
                    "WHERE id = '" + customerID + "'");

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}