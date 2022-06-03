package org.glushchenko.emart.dto;

import java.util.ArrayList;

public class ShippingNotice {
    int id;
    String shippingCompany;

    //Triplet <String, String, Integer> item = new Triplet <String, String, Integer>();

    public int getId() {return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getShippingCompany() {return shippingCompany; }

    public void setShippingCompany(String shippingCompany) {this.shippingCompany = shippingCompany; }

    //public Triplet<String, String, Integer> getItem() {return item; }

    //public void setItem(Triplet <String, String, Integer> item) {this.item = item; }

    public String toString(){
        return "Notice{" + "id: " + id + '\'' + "Shipping Company: " + shippingCompany + "}";
    }
}
