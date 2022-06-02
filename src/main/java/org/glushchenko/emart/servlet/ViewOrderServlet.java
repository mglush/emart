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
        name = "vieworderservlet",
        urlPatterns = "/ViewOrder"
)
public class ViewOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.html");
            view.forward(request, response);
        } else {
            String customerID = request.getSession().getAttribute("customer").toString();
            String orderID = request.getParameter("orderToView").toString();

            OrderService orderService = new OrderService();
            List<Product> products = orderService.displayOrderLinesContents(orderID);
            Order order = orderService.getOrderByID(orderID);
            Boolean flag = orderService.checkOrderConfirmation(orderID);
            if (flag) {
                List<String> productStrings = new ArrayList<>();
                for (Product product : products) {
                    productStrings.add(product.partialToString());
                }

                request.getSession().setAttribute("order", orderID);
                request.getSession().setAttribute("cart", productStrings);
                request.getSession().setAttribute("subtotal", orderService.getOrderSubtotal(orderID).toString());
                request.getSession().setAttribute("discount", order.getDiscount().toString());
                request.getSession().setAttribute("shipping", order.getShipping_and_handling().toString());
                request.getSession().setAttribute("total", order.getTotal().toString());

                RequestDispatcher view = request.getRequestDispatcher("viewOrder.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("noSuchOrder.jsp");
                view.forward(request, response);
            }
        }
    }
}