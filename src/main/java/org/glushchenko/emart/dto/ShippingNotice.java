package org.glushchenko.emart.dto;

import java.util.ArrayList;

public class ShippingNotice {
    String id;
    String shippingCompany;
    ArrayList<String> itemList;

    public String getId() {return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getShippingCompany() {return shippingCompany; }

    public void setShippingCompany(String shippingCompany) {this.shippingCompany = shippingCompany; }

    public ArrayList<String> getItemList() {return itemList; }

    public void setItemList(ArrayList<String> itemList) {this.itemList = itemList; }

}
