package org.glushchenko.emart.service;

public class OrderLineService {

    public OrderLine addToCart(String orderID, String productID) {
        OrderLine orderLine = new OrderLine();
        if (getOrderLine(orderID) == null)
        return orderLine;
    }

    public OrderLine removeFromCart(String orderID, String productID) {
        OrderLine orderLine = new OrderLine();
        // fill in with remove from cart.
        return orderLine;
    }

    public OrderLine getOrderLine(String orderID) {
        OrderLine orderLine = new OrderLine();
        // get an order line for some order number.
        return orderLine;
    }
}