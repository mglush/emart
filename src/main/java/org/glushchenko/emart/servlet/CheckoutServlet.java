package org.glushchenko.emart.servlet;

import org.glushchenko.emart.dto.Order;
import org.glushchenko.emart.dto.Product;
import org.glushchenko.emart.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "checkoutservlet",
        urlPatterns = "/Checkout"
)
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            String customerID = request.getSession().getAttribute("customer").toString();

            OrderService orderService = new OrderService();
            Order order = orderService.getLastOrder(customerID); // works as expected.
            Order final_order = orderService.confirmOrder(order.getId(), customerID); // implemented. still need to test this one.

            if (final_order.getChecked_out_at() != null) {
                List<Product> products = orderService.displayOrderLinesContents(order.getId());

                List<String> productStrings = new ArrayList<>();
                for (Product product : products) {
                    productStrings.add(product.partialToString());
                }

                request.getSession().setAttribute("order", order.getId());
                request.getSession().setAttribute("cart", productStrings);
                request.getSession().setAttribute("subtotal", orderService.getOrderSubtotal(order.getId()).toString());
                request.getSession().setAttribute("discount", final_order.getDiscount().toString());
                request.getSession().setAttribute("shipping", final_order.getShipping_and_handling().toString());
                request.getSession().setAttribute("total", final_order.getTotal().toString());

                if (Float.valueOf(final_order.getTotal()) > 0) {
                    RequestDispatcher view = request.getRequestDispatcher("orderConfirmation.jsp");
                    view.forward(request, response);
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("orderFailed.jsp");
                    view.forward(request, response);
                }
            } else {
                RequestDispatcher view = request.getRequestDispatcher("orderFailed.jsp");
                view.forward(request, response);
            }
        }
    }
}