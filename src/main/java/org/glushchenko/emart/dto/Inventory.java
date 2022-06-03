package org.glushchenko.emart.dto;

import java.util.ArrayList;

public class Inventory {
    String stockNumber;
    String location;
    String manufacturer;
    int qty;
    int min_lvl;
    int max_lvl;

    public String getStockNumber(){
        return stockNumber;
    }
    public void setStockNumber(String stockNumber){
        this.stockNumber = stockNumber;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public int getQty(){
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public int getMin_lvl(){
        return min_lvl;
    }
    public void setMin_lvl(int min_lvl){
        this.min_lvl = min_lvl;
    }
    public int getMax_lvl(){
        return max_lvl;
    }
    public void setMax_lvl(int max_lvl){
        this.max_lvl = max_lvl;
    }

}
