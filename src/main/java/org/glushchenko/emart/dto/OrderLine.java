package org.glushchenko.emart.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderLine {
    String order_id;

    List<String> product_id;

    List<LocalDateTime> created_at;

    List<Integer> price;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public List<String> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<String> product_id) {
        this.product_id = product_id;
    }

    public List<LocalDateTime> getCreated_at() {
        return created_at;
    }

    public void setCreated_at(List<LocalDateTime> created_at) {
        this.created_at = created_at;
    }

    public List<Integer> getPrice() {
        return price;
    }

    public void setPrice(List<Integer> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "order_id='" + order_id + '\'' +
                ", product_id=" + product_id +
                ", created_at=" + created_at +
                ", price=" + price +
                '}';
    }
}
