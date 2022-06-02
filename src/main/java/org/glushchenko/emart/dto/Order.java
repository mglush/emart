package org.glushchenko.emart.dto;

public class Order {
    String id;
    String checked_out_at;
    String discount;
    String shipping_and_handling;
    String total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChecked_out_at() {
        return checked_out_at;
    }

    public void setChecked_out_at(String checked_out_at) {
        this.checked_out_at = checked_out_at;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getShipping_and_handling() {
        return shipping_and_handling;
    }

    public void setShipping_and_handling(String shipping_and_handling) {
        this.shipping_and_handling = shipping_and_handling;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", checked_out_at='" + checked_out_at + '\'' +
                ", discount='" + discount + '\'' +
                ", shipping_and_handling='" + shipping_and_handling + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
