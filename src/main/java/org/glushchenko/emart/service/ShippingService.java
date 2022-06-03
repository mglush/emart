package org.glushchenko.emart.service;

import org.glushchenko.emart.dto.Product;
import org.glushchenko.emart.dto.ShippingNotice;
import org.glushchenko.emart.dto.Inventory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    //create a shipping notice

//    public ShippingNotice createShippingNotice(String id, String shippingCompany, ArrayList<String> itemList){
//        ShippingNotice shippingNotice = new ShippingNotice();
//        shippingNotice.setId(id);
//        shippingNotice.setShippingCompany(shippingCompany);
//        shippingNotice.setItemList(itemList);
//        return shippingNotice;
//    }

    //search for a shipping notice?

    //check quantity of an item for a given stock number
    public int checkInventory(String id){
        int qty = 0;
        String query = "" +
                "SELECT " +
                "qty " +
                "FROM inventory " +
                "WHERE " +
                "item_id = '" + id + "'";
        System.out.println(query);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "maragaw", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                qty = resultSet.getInt(1);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return qty;

    }

    public ArrayList<ShippingNotice> processNotice(){
        ArrayList<ShippingNotice> noticeList = new ArrayList<>();
        String query = "" +
                "SELECT " +
                "*" +
                "FROM notice ";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cs174a.cs.ucsb.edu:1521/xepdb1", "maragaw", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                ShippingNotice notice = new ShippingNotice();
                notice.setId(1);
                notice.setShippingCompany(resultSet.getString(2));
                noticeList.add(notice);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return noticeList;
    }




}
