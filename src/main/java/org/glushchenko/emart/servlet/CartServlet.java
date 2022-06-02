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
        name = "cartservlet",
        urlPatterns = "/Cart"
)
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            String customerID = request.getSession().getAttribute("customer").toString();
            String productID = request.getSession().getAttribute("displayID").toString();
            String count = request.getParameter("quantityToAdd").toString();

            OrderService orderService = new OrderService();
            Order order = orderService.getLastOrder(customerID); // works as expected.
            orderService.addProductToOrder(order.getId(), productID, count); // works as expected.

            List<Product> products = orderService.displayOrderLinesContents(order.getId());

            List<String> productStrings = new ArrayList<>();
            for (Product product : products) {
                productStrings.add(product.partialToString());
            }

            request.getSession().setAttribute("order", order.getId());
            request.getSession().setAttribute("cart", productStrings);
            request.getSession().setAttribute("subtotal", orderService.getOrderSubtotal(order.getId()));

            RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
            view.forward(request, response);
        }
    }
}